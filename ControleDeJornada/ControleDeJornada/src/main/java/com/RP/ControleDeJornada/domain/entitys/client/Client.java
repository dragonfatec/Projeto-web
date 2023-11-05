package com.RP.ControleDeJornada.domain.entitys.client;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
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
    private LocalDate createDate = LocalDate.now();
    private LocalDate updateClient = LocalDate.now();
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ResultCenter> resultCenter = new ArrayList<>();

    public Client (RegistrationClientRecord data){
        this.cnpj = data.cnpj().toUpperCase().trim();
        this.officialName = data.razaoSocial().toUpperCase().trim();
        this.nameCompany = data.nameCompany().toUpperCase().trim();
        this.status = Status.ACTIVE;
    }

    public void addResultCenter(ResultCenter rc){
        this.resultCenter.add((rc));

    }

}
