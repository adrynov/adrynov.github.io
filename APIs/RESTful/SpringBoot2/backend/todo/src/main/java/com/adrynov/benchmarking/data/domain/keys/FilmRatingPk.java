package com.adrynov.benchmarking.data.domain.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class FilmRatingPk implements Serializable {

//    @ManyToOne
//    private Film film;

    @Column(name="customer_id", insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    @Column(name="film_id", insertable = false, updatable = false, nullable = false)
    private Integer filmId;

    public FilmRatingPk() {
    }
}
