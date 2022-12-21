package com.adrynov.benchmarking.api;

import com.adrynov.benchmarking.data.domain.Customer;
import com.adrynov.benchmarking.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        var customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) {
        // TODO: persist customer

        //Create resource location
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(customer.getId())
//                .toUri();

//        return ResponseEntity.created(location).build();

        return ResponseEntity.ok("Model is valid, ok to implement");
    }

//    @PostMapping("/postMapping")
//    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
//        student = studentService.saveStudent(student);
//        return new ResponseEntity<>(student, HttpStatus.CREATED);
//    }
//    @PutMapping("/putMapping")
//    public ResponseEntity<Student> putExample(@RequestBody Student student) {
//        student = studentService.updateStudent(student);
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
//    @DeleteMapping("/deleteMapping")
//    public ResponseEntity<String> deleteExample(@RequestParam("student-id") String studentId) {
//        String response = studentService.deleteStudent(studentId);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
