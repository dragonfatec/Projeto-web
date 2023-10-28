package com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompoundKeyUserRC {
    private Integer registration;
    private String codeRc;
}