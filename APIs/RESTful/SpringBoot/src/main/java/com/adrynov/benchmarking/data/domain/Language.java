package com.adrynov.benchmarking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20, columnDefinition = "bpchar")
    private String name;

    // TODO: last_update timestamp now()

    protected Language() {

    }

    public Language(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}