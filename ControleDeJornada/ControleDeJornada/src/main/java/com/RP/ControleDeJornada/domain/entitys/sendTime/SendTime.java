package com.RP.ControleDeJornada.domain.entitys.sendTime;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name =  "tb_sendtime")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
public class SendTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    @Enumerated(EnumType.STRING)
    private TypeSend typeSend;
    @ManyToOne
    @JoinColumn(name = "team_code_rc")
    private ResultCenter team;
    @ManyToOne
    private User user;
    @ManyToOne
    private Client client;
    private double budget1601;
    private double budget1602;
    private double budget1809;
    private double budget3000;
    private double budget3001;
    private String justification;
    @Enumerated(EnumType.STRING)
    private TimeStatus status;
    @Enumerated(EnumType.STRING)
    private ApprovedStatus approvedStatus;

    public SendTime(@Valid ResgistrationSendTimeRecord dada){
        this.startDate = dada.startDate();
        this.finishDate = dada.finishDate();
        this.typeSend = dada.typeSend();
        this.status = TimeStatus.WAITING;
        this.approvedStatus = ApprovedStatus.WAITING_FOR_APPROVAL;
        this.justification = "-";
    }
}
