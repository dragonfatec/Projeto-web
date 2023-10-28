package com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter;

import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "r_user_resultcenter")
@Data
@NoArgsConstructor
public class RelationUserRC {
    @EmbeddedId
    private CompoundKeyUserRC compoundKey;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private ResultCenter resultCenter;

    public RelationUserRC(Integer registration, String codeRc){
        this.compoundKey = new CompoundKeyUserRC(registration,codeRc);
    }
}
