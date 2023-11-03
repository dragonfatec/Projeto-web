package com.RP.ControleDeJornada.domain.entitys.sendTime;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name =  "tb_sendtime")
@Data
@NoArgsConstructor
public class SendTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    @Enumerated(EnumType.STRING)
    private TypeSend typeSend;
    @ManyToOne(fetch = FetchType.LAZY)
    private ResultCenter team;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    private Integer budget1601;
    private Integer budget1602;
    private Integer budget1809;
    private Integer budget3000;
    private Integer budget3001;
    private String justificativa;
    @Enumerated(EnumType.STRING)
    private TimeStatus status;

    public SendTime(@Valid ResgistrationSendTimeRecord dada){
        this.startDate = dada.startDate();
        this.finishDate = dada.finishDate();
        this.typeSend = dada.typeSend();
        this.status = TimeStatus.WAITING;
    }
}
