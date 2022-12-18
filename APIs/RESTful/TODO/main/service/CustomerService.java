package com.adrynov.benchmarking.service;

import com.adrynov.benchmarking.data.domain.Customer;
import com.adrynov.benchmarking.data.repository.CustomerRepository;
import com.adrynov.benchmarking.service.contract.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        return customers;
    }

    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        return customerRepository.findCustomerByName(firstName, lastName);
    }
}
