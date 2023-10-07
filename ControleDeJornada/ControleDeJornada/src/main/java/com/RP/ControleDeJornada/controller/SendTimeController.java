package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.CustomResponse;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sendtime")
public class SendTimeController {

    @Autowired
    private SendTimeService sendTimeService;

    @GetMapping
    public ResponseEntity<CustomResponse> formRegister() {
        List<ResultCenter> rcs = sendTimeService.getAllResult();
        List<User> users = sendTimeService.getAllUsers();

        CustomResponse cr = new CustomResponse(users,rcs);

        return ResponseEntity.ok(cr);
    }

    @PostMapping
    @Transactional
    public ResponseEntity sendTime(@RequestBody @Valid ResgistrationSendTimeRecord data) {
        sendTimeService.saveTime(data);
        return ResponseEntity.ok("success!");
    }
}
