package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entidades.lancarHora.Hora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancarHoraRepository extends JpaRepository<Hora, String> {
}
