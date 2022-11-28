package com.adrynov.benchmarking.domain;

import com.adrynov.benchmarking.data.FilmActorId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId.class)
public class FilmActor {
    //    @EmbeddedId
//    private FilmActorId id;

    @Id
    private short actorId;

    @Id
    private short filmId;


//    primary key (actor_id, film_id)


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

