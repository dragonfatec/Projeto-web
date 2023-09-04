package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entidades.time.Team;
import com.RP.ControleDeJornada.domain.entidades.usuario.Rule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrationUserRecord(
        @NotBlank
        StringBuilder nome,
        @NotNull
        Rule rule,
        @NotNull
        Team team) {
}
