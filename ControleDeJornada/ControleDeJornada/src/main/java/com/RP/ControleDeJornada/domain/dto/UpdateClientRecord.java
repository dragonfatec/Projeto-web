package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UpdateClientRecord(
        @NotBlank
        String cnpj,
        String officialName,
        String nameCompany,
        Status status
) {}