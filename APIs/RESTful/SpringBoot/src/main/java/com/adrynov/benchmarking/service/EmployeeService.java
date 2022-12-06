package com.adrynov.benchmarking.service;

import com.adrynov.benchmarking.data.domain.Employee;
import com.adrynov.benchmarking.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByPerson_FirstName(name);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
         employeeRepository.findAll().forEach(employees::add);
         return employees;
    }
}
