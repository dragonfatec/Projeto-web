package com.RP.ControleDeJornada.domain.entitys.client;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter.RelationRCClient;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_client")
@Data
@NoArgsConstructor
public class Client {

    @Id
    private String cnpj;
    private String officialName;
    private String nameCompany;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createDate;
    private LocalDate updateClient;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<RelationRCClient> relation = new ArrayList<>();

    public Client (RegistrationClientRecord data){
        this.cnpj = data.cnpj().toUpperCase().trim();
        this.officialName = data.razaoSocial().toUpperCase().trim();
        this.nameCompany = data.nameCompany().toUpperCase().trim();
        this.status = Status.ACTIVE;
        this.createDate = LocalDate.now();
        this.updateClient = LocalDate.now();
    }

    public void addRelation(RelationRCClient rrcc){
        rrcc.setClient(this);
        this.relation.add(rrcc);
    }

}
