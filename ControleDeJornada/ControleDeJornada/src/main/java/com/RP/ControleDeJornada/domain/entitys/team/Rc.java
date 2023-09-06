package com.RP.ControleDeJornada.domain.entitys.team;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rc")
@Getter
@NoArgsConstructor
public class Rc {

    @Id
    private StringBuilder codeRc;
    private StringBuilder rc;
    private StringBuilder acronym;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Rc(RegistrationTeamRecord dada){
        this.codeRc = dada.codeRc();
        this.rc = dada.rc();
        this.acronym = dada.acronym();
        this.status = Status.ACTIVE;
    }
}
