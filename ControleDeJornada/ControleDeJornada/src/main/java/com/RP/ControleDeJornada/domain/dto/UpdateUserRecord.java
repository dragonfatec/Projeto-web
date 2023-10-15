package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;

public record UpdateUserRecord(
        JobRole jobRole,
        String codeRc,
        Status status){}
