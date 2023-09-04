package com.RP.ControleDeJornada.domain.entidades.time;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "time")
@Getter
@NoArgsConstructor
public class Team {

    @Id
    private StringBuilder nome;

    public Team(RegistrationTeamRecord dados){
        this.nome = dados.nome();
    }

}
