package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RcRepository extends JpaRepository<ResultCenter, String> {
}
