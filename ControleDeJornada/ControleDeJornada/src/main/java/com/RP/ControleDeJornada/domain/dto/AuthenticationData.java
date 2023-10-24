package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank
        String email,
        @NotBlank
        String password){}
