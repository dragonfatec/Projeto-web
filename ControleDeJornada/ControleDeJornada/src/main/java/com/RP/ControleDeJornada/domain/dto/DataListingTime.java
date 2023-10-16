package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.sendTime.TypeSend;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record DataListingTime(Integer idTime, LocalDateTime startDate, LocalDateTime finishDate, TypeSend typeSend) {

    public DataListingTime(SendTime time) {
        this(time.getId(), time.getStartDate(), time.getFinishDate(), time.getTypeSend());
    }
}
