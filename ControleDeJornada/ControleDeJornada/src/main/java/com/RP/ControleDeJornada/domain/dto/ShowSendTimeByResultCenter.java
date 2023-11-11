package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShowSendTimeByResultCenter(
        @NotBlank String codeRc,
        @NotBlank String jobrole,
        @NotNull Integer registration) {
}
