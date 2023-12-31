package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.ModifierRelationUserRCRecord;
import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUserRecord;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
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
    public ResponseEntity<List<ResultCenter>> getResultCenters(){
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
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUser (@RequestBody @Valid UpdateUserRecord data) {
        System.out.println(data);
        userService.updateUser(data);
        return ResponseEntity.ok("Success!");
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteRelation(@RequestBody @Valid ModifierRelationUserRCRecord data){
        userService.deleteRelation(data);
        return ResponseEntity.ok().build();
    }
}

