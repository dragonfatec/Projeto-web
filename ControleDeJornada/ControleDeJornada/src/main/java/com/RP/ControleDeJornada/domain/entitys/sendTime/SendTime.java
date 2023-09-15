package com.RP.ControleDeJornada.domain.entitys.sendTime;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name =  "sendtime")
@Getter
@Setter
@NoArgsConstructor
public class SendTime {
    @Id
    private String registration;
    @Past
    private Date startDate;
    @Past
    private Date finishDate;
    @Enumerated(EnumType.STRING)
    private TypeSend typeSend;
    @ManyToOne
    private ResultCenter team;


    public SendTime(ResgistrationSendTimeRecord dada){
        this.registration = dada.registration();
        this.startDate = dada.startDate();
        this.finishDate = dada.finishDate();
        this.typeSend = dada.typeSend();
        this.team = dada.team();

    }
}
