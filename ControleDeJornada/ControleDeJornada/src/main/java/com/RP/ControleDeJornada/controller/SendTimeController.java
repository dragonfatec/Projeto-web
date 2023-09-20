package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Transactional
    public String sendTime(@Valid ResgistrationSendTimeRecord data) {
        System.out.println(data.idUser().toString() + " , " + data.startDate().toString()+ " , " + data.finishDate().toString());
        sendTimeService.saveTime(data);
        return "timeApontament/timeApontament";

    }

}
