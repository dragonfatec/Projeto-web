package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String formRegister(Model model){
        model.addAttribute("resultCenter", userService.findAll());

        return "register/registerUser";
    }

    @PostMapping
    @Transactional
    public String register(@RequestBody @Valid RegistrationUserRecord dada){
        userService.register(dada);
        return "register/registerUser";
    }

    @GetMapping ("/rc/{codeRc}") // achar os usuarios daquele time.
    public List<User> findUserByRc (@PathVariable String codeRc) {
        return userService.findUserByRc(codeRc);
    }
}
