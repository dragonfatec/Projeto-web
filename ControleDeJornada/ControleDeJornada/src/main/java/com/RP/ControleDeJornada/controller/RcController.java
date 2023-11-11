package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.dto.ShowSendTimeByUser;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.RcService;
import com.RP.ControleDeJornada.domain.service.UserService;
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
    @Autowired
    private UserService userService;

    @GetMapping("/consult")
    public ResponseEntity<List<ResultCenter>> getResultCenters(){
        List<ResultCenter> resultCenters = rcService.findAll();
        return ResponseEntity.ok(resultCenters);
    }

    @PostMapping("/consult/by-id")
    @Transactional
    public ResponseEntity<List<ResultCenter>> getResultCenterByUser(@RequestBody @Valid ShowSendTimeByUser data){

        User user = userService.getReferenceById(data.registration());
        List<ResultCenter> resultCenters = user.getResultCenters();

        return ResponseEntity.ok(resultCenters);
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegistrationTeamRecord data){
        rcService.register(data);

        return ResponseEntity.ok("Success!");
    }
}
