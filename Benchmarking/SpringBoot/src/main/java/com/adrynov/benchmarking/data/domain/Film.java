package com.adrynov.benchmarking.data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", nullable = false)
    private Long id;

    @Column(name = "title", length = 255)
    @NotBlank(message = "Title is mandatory")
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

    // actors by film
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActors;

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Film() {
    }

}
