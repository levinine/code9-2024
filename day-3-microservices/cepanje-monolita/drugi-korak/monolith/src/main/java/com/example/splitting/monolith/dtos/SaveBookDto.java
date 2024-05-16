package com.example.splitting.monolith.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SaveBookDto(
        @NotBlank String name,
        @NotBlank String author,
        @NotNull  @Positive Integer yearPublished
) {
}
