package com.bcf.landmapper.service

import com.bcf.landmapper.dao.CountriesDao
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class RouteMapperService (@Qualifier("countriesRepository") val countriesDao: CountriesDao){

}