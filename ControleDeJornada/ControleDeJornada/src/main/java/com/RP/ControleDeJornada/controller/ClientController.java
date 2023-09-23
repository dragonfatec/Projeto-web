package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateClientRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.event.MouseMotionAdapter;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public String formRegister(String cnpj, Model model){
        if (cnpj != null){
            model.addAttribute("client",clientService.getReferenceById(cnpj));
        }

        return "register/registerClient";
    }
    @GetMapping("/consult")
    public String consult(Model model){
        model.addAttribute("clients", clientService.findAll());

        return "consult/consultClient";
    }

    @PutMapping
    @Transactional
    public String update(UpdateClientRecord data){
        Client client = clientService.getReferenceById(data.cnpj());
        client.update(data);

        return "redirect:/client/consult";
    }

    @PostMapping
    @Transactional
    public String register(@Valid RegistrationClientRecord dada){
        clientService.register(dada);
        return "register/registerClient";
    }
}
