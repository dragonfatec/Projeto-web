package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AprovationSendTimeRecord(
        @NotNull
        Integer id,
        @NotBlank
        String status,
        @NotBlank
        String jobrole,
        String justification
) {
}
