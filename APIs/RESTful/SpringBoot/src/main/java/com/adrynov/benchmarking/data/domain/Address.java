package com.adrynov.benchmarking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
    @Column(name = "address_id", nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false)
    private String addressLine1;

    @Column(name = "address2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

    @Column(name = "city_id", nullable = false)
    private int cityId;

    public Address() {
    }

    public Address(String addressLine1, String addressLine2, int cityId) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.cityId = cityId;
    }
}
//    district    varchar(20)                                                   not null,
//    postal_code varchar(10),
//    phone       varchar(20)                                                   not null,
//    last_update timestamp default now()                                       not null
