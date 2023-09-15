package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.TypeSend;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ResgistrationSendTimeRecord(

        @NotBlank
        String registration,
        @NotNull
        Date startDate,
        @NotNull
        Date finishDate,
        @NotNull
        TypeSend typeSend,
        @NotNull
        ResultCenter team)
{
}
