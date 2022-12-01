package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Data interface
 */
@Repository
//@RepositoryRestResource(collectionResourceRel = "films", path = "films")
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query(value = "SELECT title FROM film f INNER JOIN film_actor fa on f.film_id = fa.film_id WHERE actor_id = ?1", nativeQuery = true)
    Collection<String> findFilmsByActor(@Param("actorId") int actorId);

    Page<Film> findByTitle(@Param("title") String title, Pageable pageable);


    List<Film> findByTitleContaining(String title);

    List<Film> findByYear(int year);

    List<Film> findByYearLessThan(int year);

//    @Override
//    @RestResource(exported = false)
//    void deleteAll();

}
