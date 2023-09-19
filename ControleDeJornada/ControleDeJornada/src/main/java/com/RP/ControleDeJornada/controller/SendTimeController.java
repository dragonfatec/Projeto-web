package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sendtime")
public class SendTimeController {

    @Autowired
    private SendTimeService sendTimeService;

    @GetMapping
    public String formRegister() {

        return "timeApontament/timeApontament";

    }

    @PostMapping
    @Transactional
    public String sendTime(@RequestBody @Valid ResgistrationSendTimeRecord data) {
        sendTimeService.saveTime(data);
        return "timeApontament/timeApontament";

    }

}
