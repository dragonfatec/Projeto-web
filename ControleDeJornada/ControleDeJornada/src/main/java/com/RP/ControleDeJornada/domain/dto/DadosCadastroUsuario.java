package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entidades.time.Time;
import com.RP.ControleDeJornada.domain.entidades.usuario.Cargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank
        StringBuilder nome,
        @NotNull
        Cargo cargo,
        @NotNull
        Time time) {
}
