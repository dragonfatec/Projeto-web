package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.CustomResponse;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sendtime")
public class SendTimeController {

    @Autowired
    private SendTimeService sendTimeService;

    @GetMapping
    public String formRegister(Model model) {
        model.addAttribute("rcs", sendTimeService.getAllResult());
        model.addAttribute("users", sendTimeService.getAllUsers());
        return "timeApontament/timeApontament";
    }

    @GetMapping("/consult")
    public String Consult(Model model) {
        model.addAttribute("apontaments", sendTimeService.findAllSendTime());

        return "consult/consultHours";
    }

    @GetMapping("/consult")
    public ResponseEntity<List<SendTime>> getSendTimes(){
        List<SendTime> sendTimes = sendTimeService.findAllSendTime();
        return ResponseEntity.ok(sendTimes);
    }

    @PostMapping
    @Transactional
    public String sendTime(@Valid ResgistrationSendTimeRecord data) {
        sendTimeService.saveTime(data);
        return "timeApontament/timeApontament";

    }

}