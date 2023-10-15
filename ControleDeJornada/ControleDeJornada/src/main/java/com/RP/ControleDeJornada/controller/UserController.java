package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<ResultCenter>> formRegister(){
        List<ResultCenter> rcs = userService.findAllResultCenter();
        return ResponseEntity.ok(rcs);
    }

    @GetMapping("/consult")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegistrationUserRecord data){
        userService.register(data);
        return ResponseEntity.ok("Sucesso!");
    }
}
