package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendTypeRepository extends JpaRepository<SendTime, String> {
}
