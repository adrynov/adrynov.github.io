package com.adrynov.Benchmarking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_seq")
    @SequenceGenerator(name="actor_seq", sequenceName = "actor_actor_id_seq", schema = "public", allocationSize = 1)
    @Column(name = "actor_id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

//    last_update timestamp default now()                                   not null


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
