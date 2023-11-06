package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import java.time.LocalDate;

public record UpdateUserRecord(
        Integer registration,
        JobRole jobRole,
        String codeRc,
        Status status,
        String name,
        String password,
        LocalDate updateUser){}
