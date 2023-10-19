package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RcService {

    @Autowired
    private RcRepository rcRepository;

    public void register(RegistrationTeamRecord data){
        ResultCenter resultCenter = new ResultCenter(data);
        rcRepository.save(resultCenter);
    }

    public List<ResultCenter> findAll() {
        List<ResultCenter> rc = rcRepository.findAll();
        return rc;
    }

    public ResultCenter findById(String id) {
        ResultCenter rc = rcRepository.getReferenceById(id);
        return rc;
    }
}
