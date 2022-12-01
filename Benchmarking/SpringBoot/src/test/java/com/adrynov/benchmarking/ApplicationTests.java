package com.adrynov.benchmarking;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private Flyway flyway;

    @Test
    void contextLoads() {
    }

	@Test
	void triggerFlywayMigrations() {
		flyway.migrate();
	}

}
