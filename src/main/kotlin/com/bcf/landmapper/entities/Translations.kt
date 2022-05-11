package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

data class Translations(
    @JsonProperty("ces")
    val ces: Ces? = null,
    @JsonProperty("deu")
    val deu: Deu? = null,
    @JsonProperty("est")
    val est: Est? = null,
    @JsonProperty("fin")
    val fin: Fin? = null,
    @JsonProperty("fra")
    val fra: FraX? = null,
    @JsonProperty("hrv")
    val hrv: Hrv? = null,
    @JsonProperty("hun")
    val hun: Hun? = null,
    @JsonProperty("ita")
    val ita: Ita? = null,
    @JsonProperty("jpn")
    val jpn: Jpn? = null,
    @JsonProperty("kor")
    val kor: Kor? = null,
    @JsonProperty("nld")
    val nld: Nld? = null,
    @JsonProperty("per")
    val per: Per? = null,
    @JsonProperty("pol")
    val pol: Pol? = null,
    @JsonProperty("por")
    val por: Por? = null,
    @JsonProperty("rus")
    val rus: Rus? = null,
    @JsonProperty("slk")
    val slk: Slk? = null,
    @JsonProperty("spa")
    val spa: Spa? = null,
    @JsonProperty("swe")
    val swe: Swe? = null,
    @JsonProperty("urd")
    val urd: Urd? = null,
    @JsonProperty("zho")
    val zho: Zho? = null
)