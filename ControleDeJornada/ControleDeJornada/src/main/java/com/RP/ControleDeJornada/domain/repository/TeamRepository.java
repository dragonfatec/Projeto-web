package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entidades.time.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, StringBuilder> {
}
