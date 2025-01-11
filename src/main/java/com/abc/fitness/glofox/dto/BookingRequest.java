package com.abc.fitness.glofox.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Class date is mandatory")
    @FutureOrPresent(message = "Class date must be today or in the future")
    private LocalDate classDate;

}
