package com.adrynov.Benchmarking.service;

import com.adrynov.Benchmarking.domain.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorService {

    private List<Actor> actors = new ArrayList<>();

    public List<Actor> getAll() {
        return new ArrayList<>(this.actors);
    }

    public void add(Actor actor) {
        actors.add(actor);
    }

    public Optional<Actor> getByName(String actor) {
        return null;
    }
}
