package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.service.RcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rc")
@CrossOrigin("*")
public class RcController {

    @Autowired
    private RcService rcService;

    @GetMapping
    public String formRegister(){
        return "register/registerRC";
    }

    @PostMapping("/register")
    @Transactional
    public ResultCenter register(@RequestBody @Valid RegistrationTeamRecord dada){
        return rcService.register(dada);
    }

    @GetMapping ("/list")  //Aqui pega a lista com os times
    public List<ResultCenter> rcList () {
        return rcService.findAll();

    }
}
