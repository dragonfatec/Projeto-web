package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendTimeService {

    @Autowired
    private SendTypeRepository repository;

    public void saveTime(ResgistrationSendTimeRecord dados) {
        repository.save(new SendTime(dados));
    }
}
