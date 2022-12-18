package com.adrynov.benchmarking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Restful API built using Spring Boot.
 *
 * @author Andrei Drynov
 * @version 1.0
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Application started...");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
