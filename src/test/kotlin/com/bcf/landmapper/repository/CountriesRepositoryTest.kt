package com.bcf.landmapper.repository

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CountriesRepositoryTest {
    private val countriesRepository = CountriesRepository()
    @Test
    fun `should provide a list of countries`() { runBlocking {
            val countries = countriesRepository.findAllCountries()
            Assertions.assertThat(countries).isNotEmpty
        }
    }
}