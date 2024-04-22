package com.example.splitting.monolith.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record SaveUserDto(
        @NotBlank @Length(max = 35) String username,
        @NotBlank @Length(max = 35) String password
) {
}
