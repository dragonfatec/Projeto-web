package com.RP.ControleDeJornada.domain.entitys.ResultCenter;

import com.RP.ControleDeJornada.domain.dto.RegistrationResultCenterRecord;
import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.UpdateResultCenterRecord;
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

    public ResultCenter(RegistrationResultCenterRecord data){
        this.codeRc = data.codeRc().toUpperCase().trim();
        this.rc = data.rc().toUpperCase().trim();
        this.acronym = data.acronym().toUpperCase().trim();
        this.status = Status.ACTIVE;
    }

    @Override
    public String toString() {
        return rc;
    }

    public void update(UpdateResultCenterRecord data) {
        if(data.rc() != null){
            this.rc = data.rc();
        }
        if (data.acronym() != null){
            this.acronym = data.acronym();
        }
        if (data.status() != null){
            this.status = data.status();
        }
    }
}
