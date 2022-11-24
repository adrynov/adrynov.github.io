package com.adrynov.Benchmarking.data;

import com.adrynov.Benchmarking.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Data interface
 */
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByYear(int year);

    List<Film> findByTitleContaining(String title);

    default boolean deleteFilmById() {
        return true;
    }
}
