package com.adrynov.benchmarking.integration;

import com.adrynov.benchmarking.Application;
import com.adrynov.benchmarking.data.repository.EmployeeRepository;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class
)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@Disabled
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeRepository repository;

}
