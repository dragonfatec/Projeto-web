package com.RP.ControleDeJornada.domain.entidades.time;

import com.RP.ControleDeJornada.domain.dto.DadosCadastroTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "time")
@Getter
@NoArgsConstructor
public class Time {

    @Id
    private String nome;

    public Time(DadosCadastroTime dados){
        this.nome = dados.nome();
    }

}
