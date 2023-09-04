package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/time")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public String acesso(){
        return "hellow";
    }

    @PostMapping
    @Transactional
    public String salvar(@Valid RegistrationTeamRecord dados){
        teamService.salvar(dados);

        return "hellow";
    }


}
