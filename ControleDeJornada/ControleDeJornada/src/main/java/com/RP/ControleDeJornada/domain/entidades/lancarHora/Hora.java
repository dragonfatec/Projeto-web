package com.RP.ControleDeJornada.domain.entidades.lancarHora;

import com.RP.ControleDeJornada.domain.dto.DadosLancarHora;
import com.RP.ControleDeJornada.domain.entidades.time.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name =  "lancarHora")
@Getter
@Setter
@NoArgsConstructor
public class Hora {
    @Id
    private String matricula;
    @Past
    private Date dataInicial;
    @Past
    private Date dataFinal;
    @Enumerated(EnumType.STRING)
    private TipoDeLancamento tipoDeLancamento;
    @ManyToOne
    private Time time;


    public Hora (DadosLancarHora dados){
        this.matricula = dados.matricula();
        this.dataInicial = dados.dataInicial();
        this.dataFinal = dados.dataFinal();
        this.tipoDeLancamento = dados.tipo();
        this.time = dados.time();

    }
}
