package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.ApprovedDTO;
import com.RP.ControleDeJornada.domain.entitys.sendTime.ApprovedStatus;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.sendTime.TimeStatus;
import com.RP.ControleDeJornada.domain.repository.SendTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApprovedService {

    @Autowired
    private SendTimeRepository sendTypeRepository;
    public ResponseEntity approvedHoursManager(Integer id, ApprovedStatus approvedStatus, String justification ) {
        Optional<SendTime> hours = sendTypeRepository.findById(id);
        if (hours.isPresent()) {
            SendTime time = hours.get();
            if (approvedStatus != null) {
                if (approvedStatus.equals(ApprovedStatus.APPROVED_MANAGER) ||
                        approvedStatus.equals(ApprovedStatus.DENIED_MANAGER)) {
                    if (approvedStatus.equals(ApprovedStatus.DENIED_MANAGER)) {
                        if (justification != null) {
                            time.setApprovedStatus(approvedStatus);
                            time.setJustification(justification);
                            return ResponseEntity.ok("Time refused by manager");
                        }
                    }else {
                        time.setApprovedStatus(approvedStatus);
                        time.setJustification(justification);
                        return ResponseEntity.ok("Time approved by the manager!");
                    }
                }
            }
        }
        return ResponseEntity.ok("Done");
    }

    public ResponseEntity approvedHoursAdmin(Integer id, ApprovedStatus approvedStatus, String justification) {
        Optional<SendTime> hours = sendTypeRepository.findById(id);
        if (hours.isPresent()) {
            SendTime time = hours.get();
            if (approvedStatus != null && time.getApprovedStatus().equals(ApprovedStatus.APPROVED_MANAGER)) {
                if (approvedStatus.equals(ApprovedStatus.APPROVED_ADMINISTRADOR) ||
                        approvedStatus.equals(ApprovedStatus.DENIED_ADMINISTRADOR)) {
                    if (approvedStatus.equals(ApprovedStatus.DENIED_ADMINISTRADOR)) {
                        if (justification != null) {
                            time.setApprovedStatus(approvedStatus);
                            time.setJustification(justification);
                            return ResponseEntity.ok("Time refused by administrator");
                        }
                    }else {

                        time.setApprovedStatus(approvedStatus);
                        time.setJustification(justification);
                        time.setStatus(TimeStatus.APPROVED);
                        return ResponseEntity.ok("Time refused by administrator");
                    }
                }
            }
        }
        return ResponseEntity.ok("Done");
    }

}
