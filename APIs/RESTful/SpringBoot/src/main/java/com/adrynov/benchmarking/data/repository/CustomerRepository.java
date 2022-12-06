package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerByFirstNameAndLastName(String firstName, String lastName);

//    List<Student> findByFullTime(boolean fullTime);
//    List<Student> findByAge(Integer age);
//    List<Student> findByAttendeeLastName(String last);
//
//    //Query Methods with Clauses and Exrpessions
//    Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);
//    Student findByAttendee(Person person);
//    List<Student> findByAgeGreaterThan(int minimumAge);
//    List<Student> findByAgeLessThan(int maximumAge);
//    List<Student> findByAttendeeLastNameIgnoreCase(String lastName);
//    List<Student> findByAttendeeLastNameLike(String likeString);
//    Student findFirstByOrderByAttendeeLastNameAsc();
//    Student findTopByOrderByAgeDesc();
//    List<Student> findTop3ByOrderByAgeDesc();
//}

}