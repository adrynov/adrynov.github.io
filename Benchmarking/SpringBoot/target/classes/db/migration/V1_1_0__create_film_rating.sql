create table film_rating
(
    film_id     integer not null,
    customer_id integer not null,
    score       integer not null,
    comment     varchar(255),
    constraint film_rating_pk
        primary key (film_id, customer_id)
);

