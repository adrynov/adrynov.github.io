package com.adrynov.benchmarking.data;

import com.adrynov.benchmarking.data.domain.Employee;
import com.adrynov.benchmarking.data.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class EmployeeRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void employeeCrudSuccessful() {
        var employee = new Employee("Andrei", "Drynov");
        employee.setUserName("adrynov");
        employee.setAddressId(800);

        employeeRepository.save(employee);
        assertEquals(3, employeeRepository.count());

        employeeRepository.deleteById(employee.getId());
        assertEquals(2, employeeRepository.count());

    }

}