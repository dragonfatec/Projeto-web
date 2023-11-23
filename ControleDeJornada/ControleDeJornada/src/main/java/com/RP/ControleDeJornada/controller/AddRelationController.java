package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationRelationClientRC;
import com.RP.ControleDeJornada.domain.dto.RegistrationRelationUserRC;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.client.RelationClientResultCenter;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.RelationUserResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.ClientRepository;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/addRelation")
public class AddRelationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RcRepository rcRepository;

    @PostMapping("/user-rc")
    @Transactional
    public ResponseEntity<List<RelationUserResultCenter>> getRelationUserRC(@RequestBody String codeRc){

        List<Object[]> objects = userRepository.findByResultCenter(codeRc);
        List<RelationUserResultCenter> relations = new ArrayList<>();

        for (Object[] obj : objects){
            RelationUserResultCenter urc = new RelationUserResultCenter();
            urc.setUserRegistration((Integer) obj[0]);
            urc.setUserName((String) obj[1]);
            urc.setResultCentersCodeRc((String) obj[2]);
            relations.add(urc);
        }

        return ResponseEntity.ok(relations);
    }

    @PostMapping("/client-rc")
    @Transactional
    public ResponseEntity<List<RelationClientResultCenter>> getRelationClientRC(@RequestBody String cnpj){

        List<Object[]> objects = userRepository.findByClient(cnpj);
        List<RelationClientResultCenter> relations = new ArrayList<>();

        for (Object[] obj : objects){
            RelationClientResultCenter rcrc = new RelationClientResultCenter();
            rcrc.setCnpj((String) obj[0]);
            rcrc.setCodeRc((String) obj[1]);
            rcrc.setRc((String) obj[2]);
            relations.add(rcrc);
        }

        return ResponseEntity.ok(relations);
    }

    @PostMapping("/client-resultcenter")
    @Transactional
    public ResponseEntity addRelationClientRC(@RequestBody RegistrationRelationClientRC data){
        Client client = clientRepository.getReferenceById(data.idOne());
        ResultCenter rc = rcRepository.getReferenceById(data.idTwo());
        client.addResultCenter(rc);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user-resultcenter")
    @Transactional
    public ResponseEntity addRelationUserRC(@RequestBody RegistrationRelationUserRC data){
        User user = userRepository.getReferenceById(data.idOne());
        ResultCenter rc = rcRepository.getReferenceById(data.idTwo());
        user.addResultCenter(rc);
        return ResponseEntity.ok().build();
    }
}
