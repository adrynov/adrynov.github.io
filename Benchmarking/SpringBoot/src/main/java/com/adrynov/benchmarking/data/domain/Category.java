package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "category_seq")
    @SequenceGenerator(name = "category_seq", sequenceName = "category_category_id_seq", schema = "public", allocationSize = 1)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(25)")
    private String name;

    @Column(name ="last_update", nullable = false)
    @UpdateTimestamp
    private Timestamp updated;
}

//
//    create table public.category
//        (
//         integer   default nextval(''::regclass) not null
//        primary key,
//        name        varchar(25)                                                     not null,
//         timestamp default now()                                         not null
//        );
//
//        alter table public.category
//        owner to postgres;
//
//        create trigger last_updated
//        before update
//        on public.category
//        for each row
//        execute procedure public.last_updated();
//
