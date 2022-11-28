package com.adrynov.benchmarking.data;

import com.adrynov.benchmarking.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data interface
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByYear(int year);

    List<Film> findByTitleContaining(String title);

    default boolean deleteFilmById() {
        return true;
    }
}
