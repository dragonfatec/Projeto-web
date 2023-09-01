package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entidades.time.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, StringBuilder> {
}
