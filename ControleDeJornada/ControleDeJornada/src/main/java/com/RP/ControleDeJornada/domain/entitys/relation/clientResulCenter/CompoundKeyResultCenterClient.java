package com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompoundKeyResultCenterClient implements Serializable {
    private String cnpj;
    private String codeRc;
}
