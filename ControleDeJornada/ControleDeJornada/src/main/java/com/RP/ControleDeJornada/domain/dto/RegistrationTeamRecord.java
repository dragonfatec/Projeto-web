package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistrationTeamRecord(
        @NotBlank
        StringBuilder codeRc,
        @NotBlank
        StringBuilder rc,
        @NotBlank
        StringBuilder acronym
){}
