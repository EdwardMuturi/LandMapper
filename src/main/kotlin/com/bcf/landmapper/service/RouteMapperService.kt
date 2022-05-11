package com.bcf.landmapper.service

import com.bcf.landmapper.dao.CountriesDao
import com.bcf.landmapper.entities.Country
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class RouteMapperService (@Qualifier("countriesRepository") val countriesDao: CountriesDao){
    private val visited: HashMap<Country, Boolean> = HashMap()
    private val previous: HashMap<Country, Country> = HashMap()

    fun paths(origin: String, destination: String): List<String> {
        var currentCountry = countriesDao.findCountry(origin)
        val pivot = ArrayDeque<Country>()

        pivot.add(currentCountry)
        visited[currentCountry] = true

        while (pivot.isNotEmpty()) {
            currentCountry = pivot.removeAt(0)
            println("Visiting " + currentCountry.name)
            if (currentCountry.equals(destination)) {
                println("Origin and destination are equal")
                break
            } else {
                for (neighbour in currentCountry.borders) {
                    val neighbourCountry = countriesDao.findCountry(neighbour)
                    if (!visited.containsKey(neighbourCountry)) {
                        println("... registering neighbour " + neighbourCountry.name)
                        pivot.add(neighbourCountry)
                        visited[neighbourCountry] = true
                        previous[neighbourCountry] = currentCountry
                        if (neighbourCountry.equals(destination)) {
                            println("Shortest path found")
                            currentCountry = neighbourCountry
                            break
                        }
                    } else {
                        println("... skipping neighbour " + neighbourCountry.name)
                    }
                }
            }
        }
        if (!currentCountry.equals(destination)) {
            throw java.lang.IllegalStateException("Cannot reach the path")
        }
        val path: MutableList<Country> = ArrayList()
        var node: Country? = countriesDao.findCountry(destination)
        while (node != null) {
            path.add(node)
            node = previous[node]
        }
        return path.map { it.name }//.asReversed()
//        .collect(MyCollectors.reversing())
    }

    fun pathsTo(origin: String, destination: String): List<String> {
        var currentCountry = countriesDao.findCountry(origin)
        val pivot = ArrayDeque<Country>()

        pivot.add(currentCountry)
        visited[currentCountry] = true

        while (pivot.isNotEmpty()) {
            currentCountry = pivot.removeAt(0)
            println("Visiting " + currentCountry.name)
            if (currentCountry.equals(destination)) {
                println("Origin and destination are equal")
                break
            } else {
                for (neighbour in currentCountry.borders) {
                    val neighbourCountry = countriesDao.findCountry(neighbour)
                    if (!visited.containsKey(neighbourCountry)) {
                        println("... registering neighbour " + neighbourCountry.name)
                        pivot.add(neighbourCountry)
                        visited[neighbourCountry] = true
                        previous[neighbourCountry] = currentCountry
                        if (neighbourCountry.equals(destination)) {
                            println("Shortest path found")
                            currentCountry = neighbourCountry
                            break
                        }
                    } else {
                        println("... skipping neighbour " + neighbourCountry.name)
                    }
                }
            }
        }
        if (!currentCountry.equals(destination)) {
            throw java.lang.IllegalStateException("Cannot reach the path")
        }
        val path: MutableList<Country> = ArrayList()
        var node: Country? = countriesDao.findCountry(destination)
        while (node != null) {
            path.add(node)
            node = previous[node]
        }
        return path.map { it.name }//.asReversed()
//        .collect(MyCollectors.reversing())
    }
}