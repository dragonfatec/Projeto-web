package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.DadosLancarHora;
import com.RP.ControleDeJornada.domain.entidades.lancarHora.Hora;
import com.RP.ControleDeJornada.domain.repository.LancarHoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoraService {

    @Autowired
    private LancarHoraRepository repository;

    public void salvarHora(DadosLancarHora dados) {
        repository.save(new Hora(dados));
    }
}
