package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByFirstName(String firstName);
}
