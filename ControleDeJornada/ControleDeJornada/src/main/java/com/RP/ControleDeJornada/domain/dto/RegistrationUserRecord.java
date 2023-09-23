package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrationUserRecord(
        @NotBlank
        String name,
        @NotNull
        JobRole jobrole,
        @NotBlank
        String codeRc) {
}
