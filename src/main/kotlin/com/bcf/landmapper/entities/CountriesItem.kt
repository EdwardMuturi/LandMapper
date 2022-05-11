package com.bcf.landmapper.entiity


import com.fasterxml.jackson.annotation.JsonProperty

data class CountriesItem(
    @JsonProperty("altSpellings")
    val altSpellings: List<String>,
    @JsonProperty("area")
    val area: Double,
    @JsonProperty("borders")
    val borders: List<String>,
    @JsonProperty("capital")
    val capital: List<String>,
    @JsonProperty("cca2")
    val cca2: String,
    @JsonProperty("cca3")
    val cca3: String,
    @JsonProperty("ccn3")
    val ccn3: String,
    @JsonProperty("cioc")
    val cioc: String,
    @JsonProperty("currencies")
    val currencies: Currencies,
    @JsonProperty("demonyms")
    val demonyms: Demonyms,
    @JsonProperty("flag")
    val flag: String,
    @JsonProperty("idd")
    val idd: Idd,
    @JsonProperty("independent")
    val independent: Boolean,
    @JsonProperty("landlocked")
    val landlocked: Boolean,
    @JsonProperty("languages")
    val languages: Languages,
    @JsonProperty("latlng")
    val latlng: List<Int>,
    @JsonProperty("name")
    val name: Name,
    @JsonProperty("region")
    val region: String,
    @JsonProperty("status")
    val status: String,
    @JsonProperty("subregion")
    val subregion: String,
    @JsonProperty("tld")
    val tld: List<String>,
    @JsonProperty("translations")
    val translations: Translations,
    @JsonProperty("unMember")
    val unMember: Boolean
)