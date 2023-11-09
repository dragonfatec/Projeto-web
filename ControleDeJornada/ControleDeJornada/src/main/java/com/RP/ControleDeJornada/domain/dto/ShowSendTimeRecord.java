package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public record ShowSendTimeRecord(
        @NotNull
        String nameUser,
        @PastOrPresent
        LocalDateTime startDate,
        @PastOrPresent
        LocalDateTime finishDate,
        @NotBlank
        String typeSend,
        @NotBlank
        String status,
        @NotBlank
        String approvedStatus,
        String justification
) {}
