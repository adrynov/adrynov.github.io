package com.adrynov.benchmarking.service;

import com.adrynov.benchmarking.data.ActorRepository;
import com.adrynov.benchmarking.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

//    private List<Actor> actors = new ArrayList<>();

    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        repository.findAll().forEach(actors::add);
        return actors;
    }

    public void add(Actor actor) {
        repository.save(actor);
    }

    public Actor getByName(String lastName) {
        return repository.findActorByLastName(lastName);
    }
}
