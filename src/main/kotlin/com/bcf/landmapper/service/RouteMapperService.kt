package com.bcf.landmapper.service

import com.bcf.landmapper.dao.CountriesDao
import com.bcf.landmapper.entities.Country
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class RouteMapperService(@Qualifier("countriesRepository") val countriesDao: CountriesDao){
    private val logger= LoggerFactory.getLogger(RouteMapperService::class.java)

    suspend fun pathBetween(origin: String, destination: String): List<String> {
        checkGeography(origin, destination)

        val visited: HashMap<Country, Boolean> = HashMap()
        val previous: HashMap<Country, Country> = HashMap()
        var currentCountry = countriesDao.findCountry(origin)
        val destinations = ArrayDeque<Country>()

        destinations.addLast(currentCountry)
        visited[currentCountry] = true

        currentCountry = findShortestRoute(destinations, currentCountry, destination, visited, previous)
        checkDestinationNotFound(currentCountry, destination)
        return generateFoundRoute(destination, previous)
    }

    private suspend fun findShortestRoute(destinations: ArrayDeque<Country>, currentCountry: Country, destination: String, visited: HashMap<Country, Boolean>, previous: HashMap<Country, Country>): Country {
        var localCurrentCountry = currentCountry
        while (destinations.isNotEmpty()) {
            localCurrentCountry = destinations.removeFirst()
            logger.info("Visiting " + localCurrentCountry.name)
            if (localCurrentCountry.name == destination) {
                logger.info("Origin and destination are equal")
                break
            } else {
                for (neighbour in localCurrentCountry.borders) {
                    val neighbourCountry = countriesDao.findCountry(neighbour)
                    if (!visited.containsKey(neighbourCountry)) {
                        logger.info("... registering neighbour " + neighbourCountry.name)
                        destinations.add(neighbourCountry)
                        visited[neighbourCountry] = true
                        previous[neighbourCountry] = localCurrentCountry
                        if (neighbourCountry.name == destination) {
                            logger.info("Shortest path found")
                            localCurrentCountry = neighbourCountry
                            break
                        }
                    } else {
                        logger.info("... skipping neighbour " + neighbourCountry.name)
                    }
                }
            }
        }
        return localCurrentCountry
    }

    private fun checkDestinationNotFound(currentCountry: Country, destination: String) {
        if (currentCountry.name != destination) {
            throw IllegalStateException("Cannot reach the destination")
        }
    }

    private suspend fun checkGeography(origin: String, destination: String) {
        if (countriesDao.findCountry(origin).region != countriesDao.findCountry(destination).region)
            throw java.lang.IllegalStateException("Countries not connected by land")
    }

    private suspend fun generateFoundRoute(destination: String, previous: HashMap<Country, Country>): List<String> {
        val path: MutableList<Country> = ArrayList()
        var node: Country? = countriesDao.findCountry(destination)

        while (node != null) {
            path.add(node)
            node = previous[node]
        }
        return path.map { it.name }.asReversed()
    }
}