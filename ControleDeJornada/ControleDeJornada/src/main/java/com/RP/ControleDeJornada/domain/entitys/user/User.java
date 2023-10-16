package com.RP.ControleDeJornada.domain.entitys.user;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUserRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private JobRole jobrole;
    @ManyToOne
    private ResultCenter resultCenter;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User(RegistrationUserRecord data){
        this.name = data.name().toUpperCase().trim();
        this.jobrole = data.jobrole();
        this.status = Status.ACTIVE;
    }

    public void update(UpdateUserRecord data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if (data.jobrole() != null){
            this.jobrole = data.jobrole();
        }
        if(data.status() != null){
            this.status = data.status();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}