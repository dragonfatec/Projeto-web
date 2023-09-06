package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.team.Rc;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrationUserRecord(
        @NotBlank
        StringBuilder name,
        @NotNull
        JobRole jobRole,
        @NotNull
        Rc rc) {
}
