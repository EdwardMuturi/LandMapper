package com.bcf.landmapper.controller

import com.bcf.landmapper.service.RouteMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RouteMapperController @Autowired constructor(val routeMapperService: RouteMapperService){
    @GetMapping("routing/{origin}/{destination}",  "Accept=application/json")
    fun findLandRoute(@PathVariable("origin") origin: String, @PathVariable("destination") destination: String) : ResponseEntity<List<String>>{
        return try { ResponseEntity(routeMapperService.paths(origin, destination), HttpStatus.OK) }
        catch (e: Exception){ ResponseEntity(HttpStatus.BAD_REQUEST) }
    }
}