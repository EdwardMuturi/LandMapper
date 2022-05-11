package com.bcf.landmapper.dao

import com.bcf.landmapper.entities.Country

interface CountriesDao {
    fun findAllCountries(): List<Country>
}