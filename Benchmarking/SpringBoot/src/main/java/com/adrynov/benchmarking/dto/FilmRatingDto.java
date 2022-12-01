package com.adrynov.benchmarking.dto;

import com.adrynov.benchmarking.data.domain.FilmRating;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link FilmRating} entity
 */
@Data
public class FilmRatingDto implements Serializable {
    //    @Min(0)
//    @Max(5)
    private final Integer score;

    //    @Size(max = 255)
    private final String comment;

    @NotNull
    private Integer customerId;
}