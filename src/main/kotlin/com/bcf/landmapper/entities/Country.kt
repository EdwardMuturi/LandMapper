package com.bcf.landmapper.entities

data class Country(
  val name: String,
  val borders: List<String>,
  val region: String,
  val subregion: String
)