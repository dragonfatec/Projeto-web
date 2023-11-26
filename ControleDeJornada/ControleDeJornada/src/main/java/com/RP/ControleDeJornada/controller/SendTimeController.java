package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.ApprovedDTO;
import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.dto.ShowSendTimeByResultCenter;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.excel.Excel;
import com.RP.ControleDeJornada.domain.entitys.excel.SendTimeExport;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.ApprovedStatus;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import com.RP.ControleDeJornada.domain.service.ApprovedService;
import com.RP.ControleDeJornada.domain.service.SendTimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private ApprovedService approvedService;

    @GetMapping("/getClients")
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = sendTimeService.getAllClients();

        return ResponseEntity.ok(clients);
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveHours(@RequestBody @Valid ResgistrationSendTimeRecord data){
        sendTimeService.saveTime(data);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/export")
    @Transactional
    public ResponseEntity exportExcel(@RequestBody ShowSendTimeByResultCenter data){

        JobRole job = JobRole.valueOf(data.jobrole());
        List<SendTime> sendTimes;

        if (job.equals(JobRole.MANAGER)){
            sendTimes = sendTimeService.getSendTimeByManagerTeam(data.registration());

        }else if(job.equals(JobRole.EMPLOYEE)){
            sendTimes = sendTimeService.getSendTimeByUserResultCenter(data.registration(), data.codeRc());
        }else {
            sendTimes = sendTimeService.getSendTimeByResultCenterAndStatusWaiting(data.codeRc());
        }

        List<SendTimeExport> sendTimeExports = new ArrayList<>();
        Excel excel = new Excel();
        for (SendTime sendTime : sendTimes){
            SendTimeExport send = new SendTimeExport(sendTime);
            sendTimeExports.add(send);
        }
        excel.criarExcel(sendTimeExports);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/consult")
    @Transactional
    public ResponseEntity<List<SendTime>> getSendTimesByJobAndResultCenter(@RequestBody @Valid  ShowSendTimeByResultCenter data){

        JobRole job = JobRole.valueOf(data.jobrole());
        List<SendTime> sendTimes = new ArrayList<>();

        if (job.equals(JobRole.MANAGER)){
            sendTimes = sendTimeService.getSendTimeByManagerTeam(data.registration());
        }else if(job.equals(JobRole.EMPLOYEE)){
            sendTimes = sendTimeService.getSendTimeByUserResultCenter(data.registration(), data.codeRc());
        }else {
            sendTimes = sendTimeService.getSendTimeByResultCenterAndStatusWaiting(data.codeRc());
        }

        return ResponseEntity.ok(sendTimes);
    }

    @PostMapping("/getRCByClients")
    @Transactional
    public ResponseEntity<List<ResultCenter>> getRCByClients(@RequestBody String cnpj) {
        List<ResultCenter> rcs = sendTimeService.getRCByClients(cnpj);

        return ResponseEntity.ok(rcs);
    }

    @PostMapping("/approved/manager")
    @PreAuthorize("hasRole('MANAGER')")
    @Transactional
    public ResponseEntity approvedHoursManager(@RequestBody Integer id, ApprovedDTO data) {
        ApprovedStatus approvedStatus = ApprovedStatus.valueOf(data.approvedStatus());
        approvedService.approvedHoursManager(id, approvedStatus, data.justification());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/approved/admin")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @Transactional
    public ResponseEntity approvedHoursAdmin(@RequestBody ApprovedDTO data ) {
        System.out.println(data);
        ApprovedStatus approvedStatus = ApprovedStatus.valueOf(data.approvedStatus());
        approvedService.approvedHoursAdmin(data.id(), approvedStatus, data.justification());
        return ResponseEntity.ok().build();
    }
}
