package com.bcf.landmapper.controller

import com.bcf.landmapper.service.RouteMapperService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1")
class RouteMapperController(private val routeMapperService: RouteMapperService) {
    @GetMapping("route/{origin}",  "Accept=application/json")
    suspend fun findLandRoute(@PathVariable("origin") origin: String, @PathVariable("destination") destination: String) : List<String>{
        return routeMapperService.paths(origin, destination)
    }
}