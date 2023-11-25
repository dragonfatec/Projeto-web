package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModifierRelationUserRCRecord(
        @NotNull
        Integer registration,
        @NotBlank
        String codeRc
){}