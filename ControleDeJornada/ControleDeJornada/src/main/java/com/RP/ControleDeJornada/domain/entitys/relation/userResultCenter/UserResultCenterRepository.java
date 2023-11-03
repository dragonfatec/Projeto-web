package com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResultCenterRepository extends JpaRepository<RelationUserRC, Integer> {
}