package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;


public record RegistrationTeamRecord(@NotBlank StringBuilder nome) {

}
