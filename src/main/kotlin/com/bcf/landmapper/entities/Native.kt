package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

data class Native(
    @JsonProperty("bwg")
    val bwg: Bwg? = null,
    @JsonProperty("eng")
    val eng: EngX?= null,
    @JsonProperty("kck")
    val kck: Kck?= null,
    @JsonProperty("khi")
    val khi: Khi?= null,
    @JsonProperty("ndc")
    val ndc: Ndc?= null,
    @JsonProperty("nde")
    val nde: Nde?= null,
    @JsonProperty("nya")
    val nya: Nya?= null,
    @JsonProperty("sna")
    val sna: Sna?= null,
    @JsonProperty("sot")
    val sot: Sot?= null,
    @JsonProperty("toi")
    val toi: Toi?= null,
    @JsonProperty("tsn")
    val tsn: Tsn?= null,
    @JsonProperty("tso")
    val tso: Tso?= null,
    @JsonProperty("ven")
    val ven: Ven?= null,
    @JsonProperty("xho")
    val xho: Xho?= null,
    @JsonProperty("zib")
    val zib: Zib?= null
)