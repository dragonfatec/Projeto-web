package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record ModifierRelationClientRCRecord(
        @NotBlank
        String cnpj,
        @NotBlank
        String codeRc
){}