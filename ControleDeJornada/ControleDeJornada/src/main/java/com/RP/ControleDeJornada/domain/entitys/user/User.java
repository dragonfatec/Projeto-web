package com.RP.ControleDeJornada.domain.entitys.user;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.entitys.team.Rc;
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
    private Rc rc;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User(RegistrationUserRecord dada){
        this.name = dada.name();
        this.jobRole = dada.jobRole();
        this.rc = dada.rc();
        this.status = Status.ACTIVE;
    }
}
