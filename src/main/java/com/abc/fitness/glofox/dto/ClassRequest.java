package com.abc.fitness.glofox.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Start date is mandatory")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    @NotNull(message = "Capacity is mandatory")
    @Positive(message = "Capacity must be a positive number")
    private Integer capacity;

}
