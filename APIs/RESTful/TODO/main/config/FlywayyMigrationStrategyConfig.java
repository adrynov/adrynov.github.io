package com.adrynov.benchmarking.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayyMigrationStrategyConfig {

    /**
     * Disable automatic Flyway migration on startup.
     * <p>
     * Migrations can still be triggered manually.
     */
    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
        };
    }

}
