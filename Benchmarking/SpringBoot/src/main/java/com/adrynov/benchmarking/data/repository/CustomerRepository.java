package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerByFirstNameAndLastName(String firstName, String lastName);

}