package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.dto.ShowSendTimeByResultCenter;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sendtime")
public class SendTimeController {

    @Autowired
    private SendTimeService sendTimeService;

    @GetMapping("/getClients")
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = sendTimeService.getAllClients();

        return ResponseEntity.ok(clients);
    }

    @PostMapping("/consult")
    @Transactional
    public ResponseEntity<List<SendTime>> getSendTimesByJobAndResultCenter(@RequestBody @Valid ShowSendTimeByResultCenter data){

        JobRole job = JobRole.valueOf(data.jobrole());
        List<SendTime> sendTimes = new ArrayList<>();

        if (job.equals(JobRole.MANAGER)){
            sendTimes = sendTimeService.getSendTimeByManagerTeam(data.registration());
        }else if(job.equals(JobRole.EMPLOYEE)){
            sendTimes = sendTimeService.getSendTimeByUserResultCenter(data.registration(), data.codeRc());
        }else {
            sendTimes = sendTimeService.getSendTimeByResultCenter(data.codeRc());
        }

        return ResponseEntity.ok(sendTimes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity sendTime(@RequestBody @Valid ResgistrationSendTimeRecord data) {
        sendTimeService.saveTime(data);
        return ResponseEntity.ok("success!");
    }

    @PostMapping("/getRCByClients")
    @Transactional
    public ResponseEntity<List<ResultCenter>> getRCByClients(@RequestBody String cnpj) {
        List<ResultCenter> rcs = sendTimeService.getRCByClients(cnpj);

        return ResponseEntity.ok(rcs);
    }

}
