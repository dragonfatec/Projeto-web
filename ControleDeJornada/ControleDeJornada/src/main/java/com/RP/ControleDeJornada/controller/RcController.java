package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.service.RcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rc")
public class RcController {

    @Autowired
    private RcService rcService;

    @GetMapping("/consult")
    public ResponseEntity<List<ResultCenter>> getResultCenter(){
        List<ResultCenter> resultCenters = rcService.findAllResultCenter();
        return ResponseEntity.ok(resultCenters);
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegistrationTeamRecord data){
        rcService.register(data);

        return ResponseEntity.ok("Success!");
    }
}
