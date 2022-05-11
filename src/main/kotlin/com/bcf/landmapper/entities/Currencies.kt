package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

data class Currencies(
    @JsonProperty("BWP")
    val bWP: BWP? = null,
    @JsonProperty("CNY")
    val cNY: CNY? = null,
    @JsonProperty("EUR")
    val eUR: EUR? = null,
    @JsonProperty("GBP")
    val gBP: GBP? = null,
    @JsonProperty("INR")
    val iNR: INR? = null,
    @JsonProperty("JPY")
    val jPY: JPY? = null,
    @JsonProperty("USD")
    val uSD: USD? = null,
    @JsonProperty("ZAR")
    val zAR: ZAR? = null,
    @JsonProperty("ZWB")
    val zWB: ZWB? = null
)