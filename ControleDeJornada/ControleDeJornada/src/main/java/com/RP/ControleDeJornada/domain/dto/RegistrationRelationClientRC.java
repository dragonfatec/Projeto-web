package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistrationRelationClientRC(@NotBlank String idOne, @NotBlank String idTwo) {
}
