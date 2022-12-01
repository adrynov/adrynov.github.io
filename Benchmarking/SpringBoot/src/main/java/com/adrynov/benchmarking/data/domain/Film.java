package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Entity model.
 */
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", nullable = false)
    private Long id;

    @Column(name = "title", length = 255)
    private String title;

    //    @Lob
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "release_year", columnDefinition = "year")
    private int year;

    @Column(name = "language_id", columnDefinition = "language")
    private short languageId = 1;

    @Column(name = "length", columnDefinition = "smallint")
    private short length;


    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActors;

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Film() {
    }


    //    rental_duration  smallint      default 3                                     not null,

//    @Column(name="ORDER_COST", updatable=false, precision=4, scale=2)
//    public BigDecimal getCost() { return cost; }
    //    rental_rate      numeric(4, 2) default 4.99
    //
    //    not null,

    //    replacement_cost numeric(5, 2) default 19.99                                 not null,
    //    rating           mpaa_rating   default 'G'::mpaa_rating,
    //    last_update      timestamp     default now()                                 not null,
    //    special_features text[],
    //    fulltext         tsvector

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }
}
