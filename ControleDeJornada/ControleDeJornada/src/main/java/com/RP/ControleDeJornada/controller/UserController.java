package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUserRecord;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String formRegister(Integer id, Model model){
        if (id != null){
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
        }
        model.addAttribute("resultCenter", userService.findAllResultCenter());

        return "register/registerUser";
    }

    @GetMapping("/consult")
    public String consult(Model model){
        model.addAttribute("users", userService.findAllUser());
        return "consult/consultUser";
    }

    @PutMapping
    @Transactional
    public String update(UpdateUserRecord data){
        User user = userService.getUserById(data.id());
        user.update(data);

        return "redirect:/user/consult";
    }

    @PostMapping
    @Transactional
    public String register(@Valid RegistrationUserRecord data){
        userService.register(data);
        return "register/registerUser";
    }

}
