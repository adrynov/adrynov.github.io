package com.adrynov.benchmarking.service;

import com.adrynov.benchmarking.data.ActorRepository;
import com.adrynov.benchmarking.domain.Actor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ActorServiceTest {
    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorService actorService = new ActorService();

    @BeforeEach
    void setUp() {
//        when(actorRepository.findAll()).thenReturn();
    }

    @Test
    void actorListNotEmpty() {
        List<Actor> actors = actorService.getAll();

        assertNotNull(actors.isEmpty());
    }

//    @DisplayName("Adds two actors")
//    @Test
//    void addTwoActorsSuccessfully() {
//        long totalActors = actorService.countActors();
//
//        actorService.add(new Actor());
//        actorService.add(new Actor());
//
//        List<Actor> actors = actorService.getAll();
//        assertEquals(totalActors + 2, actors.size());
//    }

    @Test
    void loginSuccessIfActor() {
        Actor actor = actorService.getByName("Mel Gibson");
    }

}
