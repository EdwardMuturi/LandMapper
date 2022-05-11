package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class Name(
    @JsonProperty("common")
    val common: String,
    @JsonProperty("native")
    val native: Native,
    @JsonProperty("official")
    val official: String
)