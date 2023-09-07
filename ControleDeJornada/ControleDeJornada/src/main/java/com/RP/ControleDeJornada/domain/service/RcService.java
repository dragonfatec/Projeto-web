package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RcService {

    @Autowired
    private RcRepository rcRepository;

    public void register(RegistrationTeamRecord data){
        ResultCenter resultCenter = new ResultCenter(data);
        rcRepository.save(resultCenter);
    }
}
