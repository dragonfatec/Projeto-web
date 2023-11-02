package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.ApprovedDTO;
import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.CustomResponse;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.service.ApprovedService;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sendtime")
public class SendTimeController {

    @Autowired
    private SendTimeService sendTimeService;
    @Autowired
    private ApprovedService approvedService;

    @GetMapping
    public ResponseEntity<CustomResponse> formRegister() {
        List<ResultCenter> rcs = sendTimeService.getAllResult();
        List<User> users = sendTimeService.getAllUsers();

        CustomResponse cr = new CustomResponse(users,rcs);

        return ResponseEntity.ok(cr);
    }

    @GetMapping("/consult")
    public ResponseEntity<List<SendTime>> getSendTimes(){
        List<SendTime> sendTimes = sendTimeService.findAllSendTime();
        return ResponseEntity.ok(sendTimes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity sendTime(@RequestBody @Valid ResgistrationSendTimeRecord data) {
        sendTimeService.saveTime(data);
        return ResponseEntity.ok("success!");
    }

    @PostMapping("/approved/manager/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity approvedHoursManager(@PathVariable Integer id, @RequestBody ApprovedDTO data ) {
        approvedService.approvedHoursManager(id, data);
        return ResponseEntity.ok("success!");
    }
    @PostMapping("/approved/admin/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity approvedHoursAdmin(@PathVariable Integer id, @RequestBody ApprovedDTO data ) {
        approvedService.approvedHoursAdmin(id, data);
        return ResponseEntity.ok("success!");
    }
}
