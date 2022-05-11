package com.bcf.landmapper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class LandMapperApplication

fun main(args: Array<String>) {
	runApplication<LandMapperApplication>(*args)
}
