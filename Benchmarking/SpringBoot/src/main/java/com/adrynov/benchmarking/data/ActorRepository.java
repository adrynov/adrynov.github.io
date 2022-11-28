package com.adrynov.benchmarking.data;

import com.adrynov.benchmarking.domain.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository< Actor, Integer> {
    Actor findActorByLastName(String lastName);
}
