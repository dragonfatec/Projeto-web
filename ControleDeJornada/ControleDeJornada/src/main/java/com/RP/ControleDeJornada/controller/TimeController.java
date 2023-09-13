package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.DadosCadastroTime;
import com.RP.ControleDeJornada.domain.entidades.time.Time;
import com.RP.ControleDeJornada.domain.service.TimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public String acesso(){
        return "hellow";
    }

    @PostMapping
    @Transactional
    public Time salvar(@RequestBody @Valid DadosCadastroTime dados){
       return timeService.salvar(dados);

    }


}
