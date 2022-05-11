package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

data class Languages(
    @JsonProperty("bwg")
    val bwg: String? = null,
    @JsonProperty("eng")
    val eng: String? = null,
    @JsonProperty("kck")
    val kck: String? = null,
    @JsonProperty("khi")
    val khi: String? = null,
    @JsonProperty("ndc")
    val ndc: String? = null,
    @JsonProperty("nde")
    val nde: String? = null,
    @JsonProperty("nya")
    val nya: String? = null,
    @JsonProperty("sna")
    val sna: String? = null,
    @JsonProperty("sot")
    val sot: String? = null,
    @JsonProperty("toi")
    val toi: String? = null,
    @JsonProperty("tsn")
    val tsn: String? = null,
    @JsonProperty("tso")
    val tso: String? = null,
    @JsonProperty("ven")
    val ven: String? = null,
    @JsonProperty("xho")
    val xho: String? = null,
    @JsonProperty("zib")
    val zib: String? = null
)