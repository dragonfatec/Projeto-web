package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateClientRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/consult")
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegistrationClientRecord data){
        clientService.register(data);
        return ResponseEntity.ok("Sucesso!");
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient (@RequestBody @Valid String cnpj, UpdateClientRecord data) {
        clientService.updateClient(cnpj, data);
        return ResponseEntity.ok("Sucesso!");
    }
}
