package com.RP.ControleDeJornada.domain.entitys.client;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
@Getter
@NoArgsConstructor
public class Client {

    @Id
    private String cnpj;
    private String razaoSocial;
    private String nameCompany;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createDate;
    private LocalDate updateClient;


    public Client (RegistrationClientRecord data){
        this.cnpj = data.cnpj().toUpperCase().trim();
        this.razaoSocial = data.razaoSocial().toUpperCase().trim();
        this.nameCompany = data.nameCompany().toUpperCase().trim();
        this.status = Status.ACTIVE;
        this.createDate = LocalDate.now();
        this.updateClient = LocalDate.now();
    }

}
