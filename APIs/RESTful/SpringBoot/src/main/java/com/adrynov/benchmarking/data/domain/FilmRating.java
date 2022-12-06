package com.adrynov.benchmarking.data.domain;

import com.adrynov.benchmarking.data.domain.keys.FilmRatingPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_rating")
public class FilmRating {

    @EmbeddedId
    private FilmRatingPk key;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

}