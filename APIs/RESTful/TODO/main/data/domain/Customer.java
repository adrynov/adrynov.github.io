package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_customer_id_seq", schema = "public", allocationSize = 1)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Embedded
    private Person person;

//    @Column(name = "first_name", length = 45)
//    @NotBlank(message = "First name is mandatory")
//    private String firstName;
//
//    @Column(name = "last_name", length = 45)
//    @NotBlank(message = "Last name is mandatory")
//    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    //    store_id    smallint               not null,
    //    address_id  smallint                not null
    //        references public.address
    //            on update cascade on delete restrict,
    //    active bool  boolean   default true                   not null,

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    private Date createAt;

    @LastModifiedDate
    @Column(name = "last_update")
    private Timestamp lastUpdated;

    @Column(name = "active", columnDefinition = "int4")
    private boolean isActive;
}