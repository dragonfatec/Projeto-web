package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;

public record UpdateClientRecord(
        String cnpj,
        String nameCompany,
        Status status){}
