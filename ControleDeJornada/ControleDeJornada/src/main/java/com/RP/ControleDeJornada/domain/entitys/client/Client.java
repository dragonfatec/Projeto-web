package com.RP.ControleDeJornada.domain.entitys.client;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateClientRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Client (RegistrationClientRecord data){
        this.cnpj = data.cnpj().toUpperCase().trim();
        this.razaoSocial = data.razaoSocial().toUpperCase().trim();
        this.nameCompany = data.nameCompany().toUpperCase().trim();
        this.status = Status.ACTIVE;
    }

    public void update(UpdateClientRecord data) {
        if (data.nameCompany() != null){
            this.nameCompany = data.nameCompany().toUpperCase().trim();
        }
        if (data.status() != null){
            this.status = data.status();
        }
    }
}
