package com.RP.ControleDeJornada.domain.entitys.resultCenter;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "tb_result_center")
@Data
@NoArgsConstructor
public class ResultCenter {

    @Id
    private String codeRc;
    private String rc;
    private String acronym;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createDate = LocalDate.now();
    private LocalDate updateRC = LocalDate.now();

    public ResultCenter(RegistrationTeamRecord data){
        this.codeRc = data.codeRc().toUpperCase().trim();
        this.rc = data.rc().toUpperCase().trim();
        this.acronym = data.acronym().toUpperCase().trim();
        this.status = Status.ACTIVE;
    }

}
