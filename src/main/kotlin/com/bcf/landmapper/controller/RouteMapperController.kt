package com.bcf.landmapper.controller

import com.bcf.landmapper.controller.dto.FindRouteResponseDto
import com.bcf.landmapper.service.RouteMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RouteMapperController @Autowired constructor(val routeMapperService: RouteMapperService){
    @GetMapping("routing/{origin}/{destination}",  "Accept=application/json")
    suspend fun findLandRoute(@PathVariable("origin") origin: String, @PathVariable("destination") destination: String) : ResponseEntity<FindRouteResponseDto>{
        return try {
            val route= routeMapperService.pathBetween(origin, destination)
            ResponseEntity(FindRouteResponseDto(route, "Land route found"), HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity(FindRouteResponseDto(message = e.localizedMessage),HttpStatus.BAD_REQUEST)
        }
    }
}