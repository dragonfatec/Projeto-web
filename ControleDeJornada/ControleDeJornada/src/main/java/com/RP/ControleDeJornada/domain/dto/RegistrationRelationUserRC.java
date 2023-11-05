package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record RegistrationRelationUserRC(@NotBlank Integer idOne, @NotBlank String idTwo) {
}
