package com.adrynov.benchmarking.data;

import com.adrynov.benchmarking.data.domain.Film;
import com.adrynov.benchmarking.data.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    void findFilmsByCriteria() {
        var films = filmRepository.findByYear(2019);
        assertEquals(1, films.size());

        var breakingHome = filmRepository.findByTitleContaining("Breaking Home");
        assertNotNull(breakingHome);
    }

    @Test
    void pagingAndSortingFilms() {
        Sort sortByYear = Sort.by(Sort.Direction.ASC, "year");
//        Sort sortByLastName = new Sort(Sort.Direction.ASC, "member.lastName");
        Page<Film> films = filmRepository.findByYear(2006, PageRequest.of(0, 10, sortByYear));
        assertEquals(998, films.getTotalElements());
        assertEquals(100, films.getTotalPages());

    }

    //    @Before
//    @After
//    public void printBanner() {
//        System.out.println("*************************************************************************************");
//    }
}
