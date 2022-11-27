package com.adrynov.benchmarking

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	val logger = LoggerFactory.getLogger(Application::class.java)

	runApplication<Application>(*args)
	logger.info("Application started...")
}
