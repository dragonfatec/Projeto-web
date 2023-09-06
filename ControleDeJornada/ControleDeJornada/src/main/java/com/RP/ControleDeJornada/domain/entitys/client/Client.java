package com.RP.ControleDeJornada.domain.entitys.client;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Getter
@NoArgsConstructor
public class Client {

    @Id
    private StringBuilder cnpj;
    private StringBuilder razaoSocial;
    private StringBuilder nameCompany;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Client (RegistrationClientRecord dada){
        this.cnpj = dada.cnpj();
        this.razaoSocial = dada.razaoSocial();
        this.nameCompany = dada.nameCompany();
        this.status = Status.ACTIVE;
    }

}
