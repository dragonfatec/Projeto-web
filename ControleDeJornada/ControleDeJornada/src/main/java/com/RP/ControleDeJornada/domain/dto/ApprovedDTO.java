package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotNull;

public record ApprovedDTO(
        @NotNull
        Integer id,
        @NotNull
        String approvedStatus,
        String justification) {
}