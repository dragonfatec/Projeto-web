package com.RP.ControleDeJornada.domain.entitys.resultCenter;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter.RelationUserRC;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_result_center")
@Getter
@NoArgsConstructor
public class ResultCenter {

    @Id
    private String codeRc;
    private String rc;
    private String acronym;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createDate;
    private LocalDate updateRC;

    public ResultCenter(RegistrationTeamRecord data){
        this.codeRc = data.codeRc().toUpperCase().trim();
        this.rc = data.rc().toUpperCase().trim();
        this.acronym = data.acronym().toUpperCase().trim();
        this.status = Status.ACTIVE;
        this.createDate = LocalDate.now();
        this.updateRC = LocalDate.now();
    }

}
