package com.conexaochamados.authservice.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginResponse(
        @NotBlank String token,
        @NotBlank Long id,
        @NotBlank String name
) {}
