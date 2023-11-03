package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.RegistrationRelationClientRC;
import com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter.RCClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/addRelation")
public class AddRelationController {

    @Autowired
    private RCClientService rccs;

    @PostMapping("/client-resultcenter")
    @Transactional
    public ResponseEntity addRelation(@RequestBody RegistrationRelationClientRC data){
        rccs.addRelation(data.idOne(), data.idTwo());
        return ResponseEntity.ok().build();
    }
}
