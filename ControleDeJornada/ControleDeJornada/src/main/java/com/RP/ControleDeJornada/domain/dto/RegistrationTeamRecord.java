package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistrationTeamRecord(
        @NotBlank
        String codeRc,
        @NotBlank
        String rc,
        @NotBlank
        String acronym
){}
