package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.person.firstName = ?1 AND c.person.lastName = ?2")
    Customer findCustomerByName(String firstName, String lastName);

    @Query("SELECT c from Customer c WHERE c.person.lastName = :lastName")
    List<Customer> findCustomerByLastName(String lastName);

//    @Query("SELECT c from Customer c JOIN c.person p where p.lastName = ?1")
//    List<Person> findCustomersByLastName(String lastName);

//    @Query("Select new CourseView (c.name, c.lastName, c.department.name) from Course c where c.id=?1")
//    CourseView getCourseView(int courseId) ;
}