package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.service.RcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rc")
public class RcController {

    @Autowired
    private RcService rcService;

    @GetMapping
    public String formRegister(){
        return "register/registerRC";
    }

    @PostMapping
    @Transactional
    public String register(@Valid RegistrationTeamRecord dada){
        rcService.register(dada);

        return "register/registerRC";
    }


}
