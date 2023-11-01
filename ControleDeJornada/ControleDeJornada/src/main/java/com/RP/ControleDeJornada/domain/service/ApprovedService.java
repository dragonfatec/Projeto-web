package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.ApprovedDTO;
import com.RP.ControleDeJornada.domain.entitys.sendTime.ApprovedStatus;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.sendTime.TimeStatus;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApprovedService {

    @Autowired
    private SendTypeRepository sendTypeRepository;
    public ResponseEntity approvedHoursManager(Integer id, ApprovedDTO data ) {
        Optional<SendTime> hours = sendTypeRepository.findById(id);
        if (hours.isPresent()) {
            SendTime time = hours.get();
            if (data.approvedStatus() != null) {
                if (data.approvedStatus().equals(ApprovedStatus.APPROVED_MANAGER) ||
                        data.approvedStatus().equals(ApprovedStatus.DENIED_MANAGER)) {
                    if (data.approvedStatus().equals(ApprovedStatus.DENIED_MANAGER)) {
                        if (data.justification() != null) {
                            time.setApprovedStatus(data.approvedStatus());
                            time.setJustification(data.justification());
                            return ResponseEntity.ok("Time refused by manager");
                        }
                    }else {
                        time.setApprovedStatus(data.approvedStatus());
                        time.setJustification(data.justification());
                        return ResponseEntity.ok("Time approved by the manager!");
                    }
                }
            }
        }
        return ResponseEntity.ok("Done");
    }

    public ResponseEntity approvedHoursAdmin(Integer id, ApprovedDTO data ) {
        Optional<SendTime> hours = sendTypeRepository.findById(id);
        if (hours.isPresent()) {
            SendTime time = hours.get();
            if (data.approvedStatus() != null && time.getApprovedStatus().equals(ApprovedStatus.APPROVED_MANAGER)) {
                if (data.approvedStatus().equals(ApprovedStatus.APPROVED_ADMINISTRADOR) ||
                        data.approvedStatus().equals(ApprovedStatus.DENIED_ADMINISTRADOR)) {
                    if (data.approvedStatus().equals(ApprovedStatus.DENIED_ADMINISTRADOR)) {
                        if (data.justification() != null) {
                            time.setApprovedStatus(data.approvedStatus());
                            time.setJustification(data.justification());
                            return ResponseEntity.ok("Time refused by administrator");
                        }
                    }else {

                        time.setApprovedStatus(data.approvedStatus());
                        time.setJustification(data.justification());
                        time.setStatus(TimeStatus.APPROVED);
                        return ResponseEntity.ok("Time refused by administrator");
                    }
                }
            }
        }
        return ResponseEntity.ok("Done");
    }

}
