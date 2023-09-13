package com.RP.ControleDeJornada.domain.entidades.usuario;

import com.RP.ControleDeJornada.domain.dto.DadosCadastroUsuario;
import com.RP.ControleDeJornada.domain.entidades.time.Time;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private StringBuilder nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @ManyToOne
    private Time time;

    public Usuario(DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.cargo = dados.cargo();
        this.time = dados.time();
    }
}
