package com.adrynov.benchmarking.api;

import com.adrynov.benchmarking.data.domain.Film;
import com.adrynov.benchmarking.data.repository.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/films")
//@CrossOrigin("http://localhost:8080")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Film>> getAllFilms(@RequestParam(required = false) String title) {
        try {
            List<Film> films = new ArrayList<>();

            if (title != null) {
                films.addAll(filmRepository.findByTitleContaining(title));
            } else {
//                films.addAll(filmRepository.findAll());
            }

            if (films.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(films, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable("id") long id) {
        var data = filmRepository.findById(id);

        return data
                .map(film -> new ResponseEntity<>(film, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Film> addFilm(@RequestBody Film data) {
        try {
            Film film = new Film(data.getTitle(), data.getDescription());
            film.setId(data.getId());
            film.setYear(data.getYear());
            film.setLength(data.getLength());

            var entity = filmRepository.save(film);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable("id") long id, @RequestBody Film film) {
        if (id != film.getId()) throw new IllegalArgumentException("IDs do not match");

        var entity = filmRepository.findById(id);

        if (entity.isPresent()) {
            Film updatedFilm = entity.get();
            updatedFilm.setTitle(film.getTitle());
            updatedFilm.setDescription(film.getDescription());
            return new ResponseEntity<>(updatedFilm, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFilm(@PathVariable("id") long id) {
        try {
            filmRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
