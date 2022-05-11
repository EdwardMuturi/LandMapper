package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class ZWB(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("symbol")
    val symbol: String
)