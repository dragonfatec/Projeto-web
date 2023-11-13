package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;

import java.time.LocalDate;

public record UpdateRcRecord(
        String rc,
        String acronym,
        Status status,
        LocalDate updateRc) {
}
