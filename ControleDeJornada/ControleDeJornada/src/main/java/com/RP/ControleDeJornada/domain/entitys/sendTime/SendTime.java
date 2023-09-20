package com.RP.ControleDeJornada.domain.entitys.sendTime;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name =  "tb_sendtime")
@Getter
@Setter
@NoArgsConstructor
public class SendTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    @Enumerated(EnumType.STRING)
    private TypeSend typeSend;
    @ManyToOne
    private ResultCenter team;
    @ManyToOne
    private User user;


    public SendTime(@Valid ResgistrationSendTimeRecord dada){
        this.startDate = dada.startDate();
        this.finishDate = dada.finishDate();
        this.typeSend = dada.typeSend();
    }
}
