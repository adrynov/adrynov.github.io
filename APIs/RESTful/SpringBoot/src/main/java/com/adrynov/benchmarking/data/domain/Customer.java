package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "first_name", length = 45)
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column(name = "last_name", length = 45)
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    //    store_id    smallint               not null,
    //    address_id  smallint                not null
    //        references public.address
    //            on update cascade on delete restrict,
    //    activebool  boolean   default true                   not null,
    //    create_date date      default ('now'::text)::date       not null,
    //    last_update timestamp default now(),
    //    active      integer
    //);
    //
    //alter table public.customer
    //    owner to postgres;
    //
    //create index idx_fk_address_id
    //    on public.customer (address_id);
    //
    //create index idx_fk_store_id
    //    on public.customer (store_id);
    //
    //create index idx_last_name
    //    on public.customer (last_name);
    //
    //create trigger last_updated
    //    before update
    //    on public.customer
    //    for each row
    //execute procedure public.last_updated();
}