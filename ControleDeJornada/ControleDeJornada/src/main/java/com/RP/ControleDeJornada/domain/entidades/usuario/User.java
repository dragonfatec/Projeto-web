package com.RP.ControleDeJornada.domain.entidades.usuario;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.entidades.time.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private StringBuilder nome;
    @Enumerated(EnumType.STRING)
    private Rule rule;
    @ManyToOne
    private Team team;

    public User(RegistrationUserRecord dados){
        this.nome = dados.nome();
        this.rule = dados.rule();
        this.team = dados.team();
    }
}
