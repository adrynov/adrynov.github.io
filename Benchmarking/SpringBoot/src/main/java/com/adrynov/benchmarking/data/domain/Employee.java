package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_staff_id_seq", schema = "public", allocationSize = 1)
    @Column(name = "staff_id", nullable = false)
    private Integer id;

//    @Size(min = 3, max = 20)
    @Column(name="first_name", length = 45, columnDefinition = "varchar(45)", nullable = false)
    private String firstName;


    //    last_name   varchar(45)                                               not null,
    //    address_id  smallint                                                  not null
    //        references public.address
    //            on update cascade on delete restrict,
    //    email       varchar(50),
    //    store_id    smallint                                                  not null,
    //    active      boolean   default true                                    not null,
    //    username    varchar(16)                                               not null,
    //    password    varchar(40),
    //    last_update timestamp default now()                                   not null,
    //    picture     bytea
    //);
    //
    //alter table public.staff
    //    owner to postgres;
    //
    //create trigger last_updated
    //    before update
    //    on public.staff
    //    for each row
    //execute procedure public.last_updated();
}
