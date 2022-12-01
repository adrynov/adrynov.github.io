package com.adrynov.benchmarking.data.domain;

import com.adrynov.benchmarking.data.domain.keys.FilmRatingPk;
import jakarta.persistence.*;

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