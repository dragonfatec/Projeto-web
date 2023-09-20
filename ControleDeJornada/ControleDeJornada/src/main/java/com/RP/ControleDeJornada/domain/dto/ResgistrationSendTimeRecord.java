package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.sendTime.TypeSend;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.util.Date;

public record ResgistrationSendTimeRecord(
        @NotNull
        Integer idUser,
        @NotNull
        @PastOrPresent
        Date startDate,
        @NotNull
        @PastOrPresent
        Date finishDate,
        @NotNull
        TypeSend typeSend,
        @NotBlank
        String codeRc){}
