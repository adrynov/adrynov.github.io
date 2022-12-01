package com.adrynov.benchmarking.data.domain;

import com.adrynov.benchmarking.data.domain.keys.FilmActorId;
import jakarta.persistence.*;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId.class)  // primary key (actor_id, film_id)
public class FilmActor {
    @Id
    private short actorId;

    @Id
    private short filmId;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    public FilmActor() {
    }

    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }
}

