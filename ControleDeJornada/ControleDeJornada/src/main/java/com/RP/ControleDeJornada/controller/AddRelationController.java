package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationRelationClientRC;
import com.RP.ControleDeJornada.domain.dto.RegistrationRelationUserRC;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.ClientRepository;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
