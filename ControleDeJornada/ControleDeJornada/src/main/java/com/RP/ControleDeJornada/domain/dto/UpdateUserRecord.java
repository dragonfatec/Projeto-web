package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateUserRecord(
        @NotNull
        Integer registration,
        JobRole jobRole,
        Status status,
        String name,
        String password,
        String email
){}