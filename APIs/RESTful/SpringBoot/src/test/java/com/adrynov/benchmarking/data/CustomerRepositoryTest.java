package com.adrynov.benchmarking.data;

import com.adrynov.benchmarking.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;
}
