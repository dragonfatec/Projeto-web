package com.RP.ControleDeJornada.domain.entitys.ResultCenter;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public ResultCenter(RegistrationTeamRecord data){
        this.codeRc = data.codeRc().toUpperCase().trim();
        this.rc = data.rc().toUpperCase().trim();
        this.acronym = data.acronym().toUpperCase().trim();
        this.status = Status.ACTIVE;
    }
}
