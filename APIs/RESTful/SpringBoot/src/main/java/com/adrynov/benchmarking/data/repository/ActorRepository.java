package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    Optional<Actor> findActorByFirstNameAndLastName(String firstName, String lastName);

    Actor findActorByLastName(String lastName);
}
