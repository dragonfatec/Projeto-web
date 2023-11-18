package com.RP.ControleDeJornada.domain.entitys.excel;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import lombok.Data;

@Data
public class SendTimeExport {

    private String startDate;
    private String finishDate;
    private String typeSend;
    private String team;
    private String nome;
    private String email;
    private String client;
    private double budget1601;
    private double budget1602;
    private double budget1809;
    private double budget3000;
    private double budget3001;
    private String justification;
    private String status;
    private String approvedStatus;

    public SendTimeExport(SendTime sendTime){
        this.startDate = sendTime.getStartDate().toString();
        this.finishDate = sendTime.getFinishDate().toString();
        this.typeSend = sendTime.getTypeSend().toString();
        this.team = sendTime.getTeam().getAcronym().toString();
        this.nome = sendTime.getUser().getName();
        this.email = sendTime.getUser().getEmail();
        this.client = sendTime.getClient().getNameCompany();
        this.budget1601 = sendTime.getBudget1601();
        this.budget1602 = sendTime.getBudget1602();
        this.budget1809 = sendTime.getBudget1809();
        this.budget3000 = sendTime.getBudget3000();
        this.budget3001 = sendTime.getBudget3001();
        this.justification = sendTime.getJustification();
        this.status = sendTime.getStatus().toString();
        this.approvedStatus = sendTime.getApprovedStatus().toString();
    }
}
