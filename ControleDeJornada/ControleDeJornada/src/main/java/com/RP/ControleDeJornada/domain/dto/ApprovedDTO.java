package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.sendTime.ApprovedStatus;

public record ApprovedDTO(ApprovedStatus approvedStatus, String justification) {
}
