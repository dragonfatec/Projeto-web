package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entidades.lancarHora.TipoDeLancamento;
import com.RP.ControleDeJornada.domain.entidades.time.Time;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosLancarHora (

        @NotBlank
        String matricula,
        @NotNull
        Date dataInicial,
        @NotNull
        Date dataFinal,
        @NotNull
        TipoDeLancamento tipo,
        @NotNull
        Time time) {
}
