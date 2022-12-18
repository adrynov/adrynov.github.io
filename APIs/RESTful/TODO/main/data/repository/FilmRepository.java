package com.adrynov.benchmarking.data.repository;

import com.adrynov.benchmarking.data.domain.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

//    @Query(value = "SELECT title FROM film f INNER JOIN film_actor fa on f.film_id = fa.film_id WHERE actor_id = ?1", nativeQuery = true)
//    Collection<String> findFilmsByActor(@Param("actorId") int actorId);

    List<Film> findByTitleContaining(String title);

    List<Film> findByTitleIgnoreCase(String title);

    List<Film> findByTitleLike(String title);

    List<Film> findByYear(int year);
    Page<Film> findByYear(@Param("year") int year, Pageable pageable);

    /**
     * Find the oldest film
     */
    Film findTopByOrderByYearAsc();

    /**
     * Find 3 newest films
     */
    List<Film> findTop3ByOrderByYearDesc();

    List<Film> findByLengthGreaterThan(int length);

}
