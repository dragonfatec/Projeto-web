package com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter;


import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "r_resultcenter_client")
@NoArgsConstructor
@Data
public class RelationRCClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    private ResultCenter resultCenter;
    private LocalDate createDate;

    public RelationRCClient(Client client, ResultCenter resultCenter){
        this.client = client;
        this.resultCenter = resultCenter;
        this.createDate = LocalDate.now();
    }

}
