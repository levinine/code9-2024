package com.example.splitting.monolith.clients.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LibrarySaveBookDto(
        @NotBlank String name,
        @NotBlank String author,
        @NotNull @Positive Integer yearPublished
) {
}
