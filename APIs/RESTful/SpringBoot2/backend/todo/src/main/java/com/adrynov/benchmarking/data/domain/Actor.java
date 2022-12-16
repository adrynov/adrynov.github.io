package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_seq")
    @SequenceGenerator(name = "actor_seq", sequenceName = "actor_actor_id_seq", schema = "public", allocationSize = 1)
    @Column(name = "actor_id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

//    last_update timestamp default now()                                   not null


    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor() {
    }
}
