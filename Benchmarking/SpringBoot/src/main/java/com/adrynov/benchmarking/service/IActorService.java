package com.adrynov.benchmarking.service;

import com.adrynov.benchmarking.data.domain.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> getAll();

    void add(Actor actor);

    Actor getByName(String lastName);

}
