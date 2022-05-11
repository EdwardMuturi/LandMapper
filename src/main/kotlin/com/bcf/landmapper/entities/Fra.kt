package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class Fra(
    @JsonProperty("f")
    val f: String,
    @JsonProperty("m")
    val m: String
)