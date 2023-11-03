package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter.RelationUserRC;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RcService {

    @Autowired
    private RcRepository rcRepository;

    @Autowired
    private UserRepository userRepository;

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

//    public void addRelation(Integer registration, String codeRc){
//        ResultCenter rc = rcRepository.getReferenceById(codeRc);
//        User user = userRepository.getReferenceById(registration);
//        RelationUserRC rurc = new RelationUserRC(user, rc);
//        user.addRelation(rurc);
//    }

    public ResultCenter getReferenceById(String codeRc) {
        ResultCenter rc = rcRepository.getReferenceById(codeRc);
        return rc;
    }
}
