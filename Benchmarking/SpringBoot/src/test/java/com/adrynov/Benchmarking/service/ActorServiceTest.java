package com.adrynov.Benchmarking.service;

import com.adrynov.Benchmarking.domain.Actor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorServiceTest {

    private ActorService actorService;

    @BeforeEach
    void setUp() {
        actorService = new ActorService();
    }

    @Test
    void listEmptyIfNoActorAdded() {
        List<Actor> actors = actorService.getAll();

        assertTrue(actors.isEmpty());
    }

    @Test
    void addTwoActorsSuccessfully() {
        actorService.add(new Actor());
        actorService.add(new Actor());

        List<Actor> actors = actorService.getAll();
        assertEquals(2, actors.size());
    }

    @Test
    void loginSuccessIfActor() {
        Optional<Actor> actor = actorService.getByName("Mel Gibson");
    }

}
