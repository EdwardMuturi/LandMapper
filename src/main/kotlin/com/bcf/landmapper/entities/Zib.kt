package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class Zib(
    @JsonProperty("common")
    val common: String,
    @JsonProperty("official")
    val official: String
)