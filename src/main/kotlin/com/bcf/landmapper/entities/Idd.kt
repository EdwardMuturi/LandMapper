package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class Idd(
    @JsonProperty("root")
    val root: String,
    @JsonProperty("suffixes")
    val suffixes: List<String>
)