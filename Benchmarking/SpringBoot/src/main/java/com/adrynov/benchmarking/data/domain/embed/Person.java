package com.adrynov.benchmarking.data.domain.embed;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Person {
    //    @Size(min = 3, max = 20)
    @Column(name = "first_name", length = 45, columnDefinition = "varchar(45)", nullable = false)
    private String firstName;


    //    @Size(min = 3, max = 20)
    @Column(name = "last_name", length = 45, columnDefinition = "varchar(45)", nullable = false)
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
