package com.adrynov.benchmarking.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq", sequenceName = "city_city_id_seq", allocationSize = 1)
    @Column(name = "city_id", nullable = false)
    private Integer id;

    @Column(name = "city", nullable = false)
    private String cityName;

    //    country_id  smallint            not null

//    last_update timestamp default now()                                 not null

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public City(String name) {
        this.cityName = name;
    }

    public City() {

    }
}