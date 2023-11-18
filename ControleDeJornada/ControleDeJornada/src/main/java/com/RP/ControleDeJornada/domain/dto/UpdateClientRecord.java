package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;

import java.time.LocalDate;

public record UpdateClientRecord(
        String officialName,
        String nameCompany,
        Status status,
        LocalDate updateClient) {
}
