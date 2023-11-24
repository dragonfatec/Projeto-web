package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.Status;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record UpdateRcRecord(
        @NotBlank
        String codeRc,
        String rc,
        String acronym,
        Status status,
        LocalDate updateRc) {
}
