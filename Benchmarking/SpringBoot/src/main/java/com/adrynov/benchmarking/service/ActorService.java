package com.adrynov.benchmarking.service;

import com.adrynov.benchmarking.data.domain.Actor;
import com.adrynov.benchmarking.data.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private  ActorRepository repository;

    public Actor createActor(String firstName, String lastName) {
        return repository
                .findActorByFirstNameAndLastName(firstName, lastName)
                .orElse(repository.save(new Actor(firstName, lastName)));

    }

    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        repository.findAll().forEach(actors::add);
        return actors;
    }

    public void add(Actor actor) {
        repository.save(actor);
    }

    public Actor findByName(String lastName) {
        return repository.findActorByLastName(lastName);
    }

    public long total() {
        return repository.count();
    }
}
