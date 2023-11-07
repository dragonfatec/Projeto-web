package com.RP.ControleDeJornada.controller;


import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.dto.ShowSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/consult")
    public ResponseEntity<List<ShowSendTimeRecord>> getSendTimes(){
        List<ShowSendTimeRecord> sendTimes = sendTimeService.findAllSendTime();
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
