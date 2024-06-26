package co.edu.uniquindio.model.dto;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO (
        @NotBlank
        String token,

        String refreshToken
){}
