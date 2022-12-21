package com.adrynov.benchmarking.service.contract;

import com.adrynov.benchmarking.data.domain.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();

    Customer getCustomerByName(String firstName, String lastName);
}
