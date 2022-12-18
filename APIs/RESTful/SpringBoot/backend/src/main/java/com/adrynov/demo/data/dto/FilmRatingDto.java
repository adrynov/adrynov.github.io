package com.adrynov.demo.data.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link FilmRating} entity
 */
@Data
public class FilmRatingDto implements Serializable {
    @Min(0)
    @Max(5)
    private final Integer score;

    @Size(max = 255)
    private final String comment;

    @NotNull
    private Integer customerId;
}