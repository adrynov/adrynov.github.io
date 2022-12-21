package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Employee;
import com.adrynov.benchmarking.data.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByUserName(String userName);

    List<Employee> findByPersonLastName(String lastName);
    Employee findByPersonFirstNameAndPersonLastName(String firstName, String lastName);
    Employee findByPerson(Person person);

//    List<Student> findByAttendeeLastNameIgnoreCase(String lastName);
//    List<Student> findByAttendeeLastNameLike(String likeString);
//    Student findFirstByOrderByAttendeeLastNameAsc();

    //    List<Student> findByAgeGreaterThan(int minimumAge);
//    List<Student> findByAgeLessThan(int maximumAge);
//    Student findTopByOrderByAgeDesc();
//    List<Student> findTop3ByOrderByAgeDesc();

}
