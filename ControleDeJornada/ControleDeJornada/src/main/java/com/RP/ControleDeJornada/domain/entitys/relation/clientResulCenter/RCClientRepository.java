package com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCClientRepository extends JpaRepository<RelationRCClient, Integer> {
}
