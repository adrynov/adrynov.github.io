package com.adrynov.benchmarking.data.domain;

import com.adrynov.benchmarking.data.domain.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_staff_id_seq", schema = "public", allocationSize = 1)
    @Column(name = "staff_id", nullable = false)
    private Integer id;

    @Embedded
    private Person person;

    @Column(name = "username", nullable = false, columnDefinition = "varchar(16)")
    private String userName;

    @Column(name = "address_id", nullable = false)
    private int addressId;

    @Column(name = "store_id", nullable = false)
    private int storeId;

    @Column(name = "active", nullable = false)
    private boolean isActive = true;

    protected Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.person = new Person(firstName, lastName);

        this.storeId = 1;
    }


    //    email       varchar(50),
    //    password    varchar(40),
    //    last_update timestamp default now() not null,
    //    picture     bytea


    @Override
    public String toString() {
        return this.person.toString();
    }
}
