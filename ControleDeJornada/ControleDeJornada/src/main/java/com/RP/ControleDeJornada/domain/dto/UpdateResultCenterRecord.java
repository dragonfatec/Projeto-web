package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;

public record UpdateResultCenterRecord(

        String codeRc,
        String rc,
        String acronym,
        Status status){}
