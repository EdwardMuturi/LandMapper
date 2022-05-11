package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class Demonyms(
    @JsonProperty("eng")
    val eng: Eng,
    @JsonProperty("fra")
    val fra: Fra
)