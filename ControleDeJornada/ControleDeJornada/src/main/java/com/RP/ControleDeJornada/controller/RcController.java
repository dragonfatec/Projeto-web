package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationResultCenterRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateResultCenterRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.service.RcService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rc")
public class RcController {

    @Autowired
    private RcService rcService;

    @GetMapping
    public String formRegister(String codeRc, Model model){
        if(codeRc != null){
            model.addAttribute("rcs", rcService.getReferenceById(codeRc));
        }

        return "register/registerRC";
    }

    @GetMapping("/consult")
    public String consult(Model model){
        model.addAttribute("rcs", rcService.findAll());

        return "consult/consultResultCenter";
    }

    @PutMapping
    @Transactional
    public String update(UpdateResultCenterRecord data){
        ResultCenter rc = rcService.getReferenceById(data.codeRc());
        rc.update(data);

        return "redirect:/rc/consult";
    }

    @PostMapping
    @Transactional
    public String register(@Valid RegistrationResultCenterRecord data){
        rcService.register(data);

        return "register/registerRC";
    }

}
