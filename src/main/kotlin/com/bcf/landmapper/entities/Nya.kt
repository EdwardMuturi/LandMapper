package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class Nya(
    @JsonProperty("common")
    val common: String,
    @JsonProperty("official")
    val official: String
)