package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;

public record UpdateUserRecord(
        Integer id,
        String name,
        JobRole jobrole,
        String codeRc,
        Status status) {}
