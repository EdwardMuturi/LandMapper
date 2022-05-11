package com.bcf.landmapper.repository

import com.bcf.landmapper.dao.CountriesDao
import com.bcf.landmapper.entiity.Countries
import com.bcf.landmapper.entities.Country
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import org.springframework.util.FileCopyUtils
import java.nio.charset.StandardCharsets

@Component("countriesRepository")
class CountriesRepository : CountriesDao{
    private val jsonMapper= ObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    override fun findAllCountries(): List<Country> {
        return jsonMapper
            .readValue(readCountriesFile(), Countries::class.java)
            .map { Country(it.cca3, it.borders, it.region, it.subregion) }
    }

    private fun readCountriesFile(): String? {
        var data: String? = null
        val countriesClassPathResource = ClassPathResource("countries/countries.json")

        try {
            val journeyByteArray = FileCopyUtils.copyToByteArray(countriesClassPathResource.inputStream)
            data = String(journeyByteArray, StandardCharsets.UTF_8)
        } catch (e: Exception) {
            println(e.localizedMessage)
        }

        return data
    }
}