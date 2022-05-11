package com.bcf.landmapper.controller.dto

data class FindRouteResponseDto(
    val route: List<String> = emptyList(),
    val message: String
)
