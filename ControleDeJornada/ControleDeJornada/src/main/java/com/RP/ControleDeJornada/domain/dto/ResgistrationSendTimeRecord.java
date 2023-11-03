package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.sendTime.TypeSend;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;


public record ResgistrationSendTimeRecord(
        @NotNull
        String registration,
        @NotNull
        @PastOrPresent
        LocalDateTime startDate,
        @NotNull
        @PastOrPresent
        LocalDateTime finishDate,
        @NotNull
        TypeSend typeSend,
        @NotBlank
        String resultCenters,
        @NotBlank
        String client){}
