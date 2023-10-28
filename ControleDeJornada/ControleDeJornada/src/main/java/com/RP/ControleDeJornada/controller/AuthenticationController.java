package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.AuthenticationData;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.infra.security.TokenData;
import com.RP.ControleDeJornada.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    @Transactional
    public ResponseEntity login(@RequestBody @Valid AuthenticationData data){

        var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var token = tokenService.tokenGeneration((User) authentication.getPrincipal());
        var jobrole = tokenService.extractJobRoleClaim(token);
        var tk = new TokenData(token, jobrole);

        return ResponseEntity.ok(tk);
    }
}
