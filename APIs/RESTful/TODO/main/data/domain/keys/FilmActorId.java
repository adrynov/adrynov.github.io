package com.adrynov.benchmarking.data.domain.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorId implements Serializable {

    @Column(name = "actor_id", columnDefinition = "smallint", nullable = false)
    private short actorId;

    @Column(name = "film_id", columnDefinition = "smallint", nullable = false, insertable = false, updatable = false)
    private short filmId;

    public FilmActorId() {
    }

    public FilmActorId(short actorId, short filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public short getActorId() {
        return actorId;
    }

    public short getFilmId() {
        return filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return actorId == that.actorId && filmId == that.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}
