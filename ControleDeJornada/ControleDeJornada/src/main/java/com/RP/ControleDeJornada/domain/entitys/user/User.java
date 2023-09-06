package com.RP.ControleDeJornada.domain.entitys.user;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private StringBuilder name;
    @Enumerated(EnumType.STRING)
    private JobRole jobRole;
    @ManyToOne
    private ResultCenter resultCenter;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User(RegistrationUserRecord data){
        this.name = data.name();
        this.jobRole = data.jobRole();
        this.resultCenter = data.resultCenter();
        this.status = Status.ACTIVE;
    }
}
