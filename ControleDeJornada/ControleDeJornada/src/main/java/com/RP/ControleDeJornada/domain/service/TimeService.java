package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.DadosCadastroTime;
import com.RP.ControleDeJornada.domain.entidades.time.Time;
import com.RP.ControleDeJornada.domain.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public void salvar(DadosCadastroTime dados){
        Time time = new Time(dados);
        timeRepository.save(time);
    }
}
