package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.DadosLancarHora;
import com.RP.ControleDeJornada.domain.service.HoraService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hora")
public class LancarHoraController {

    @Autowired
    private HoraService horaService;

    @GetMapping
    public String acesso() {
        return "acesso";
    }

    @PostMapping
    @Transactional
    public String lancarHora(@RequestBody @Valid DadosLancarHora dados) {
        horaService.salvarHora(dados);
        return "salvo";
    }

}
