package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class DashboardController {

    SendTypeRepository str;
    UserRepository ur;

    public ResponseEntity<List<SendTime>> findHourToDashboard(Integer idUser){
        User userSelection = ur.findByRegistration(idUser);
        if (userSelection == null) {
            return ResponseEntity.notFound().build();
        }
        List<SendTime> hourPerUser = str.findSendTimesByUser(userSelection);
        return ResponseEntity.ok().body(hourPerUser);
    }
}
