package com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "r_resultcenter_client")
public class RelationResultCenterClient {
    @EmbeddedId
    private CompoundKeyResultCenterClient id;

}
