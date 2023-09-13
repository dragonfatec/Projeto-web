package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public String formRegister(){

        return "register/registerClient";
    }

    @PostMapping
    @Transactional
    public String register(@Valid RegistrationClientRecord dada){
        clientService.register(dada);
        return "register/registerClient";
    }
}
