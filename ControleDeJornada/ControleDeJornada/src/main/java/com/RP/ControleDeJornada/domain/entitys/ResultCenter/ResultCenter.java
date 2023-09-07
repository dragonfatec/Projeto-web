package com.RP.ControleDeJornada.domain.entitys.ResultCenter;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "result_center")
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
        this.codeRc = data.codeRc();
        this.rc = data.rc();
        this.acronym = data.acronym();
        this.status = Status.ACTIVE;
    }
}
