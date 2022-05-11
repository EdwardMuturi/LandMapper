package com.bcf.landmapper.dao

import com.bcf.landmapper.entities.Country

interface CountriesDao {
    suspend fun findAllCountries(): List<Country>
    suspend fun findCountry(name: String) : Country
}