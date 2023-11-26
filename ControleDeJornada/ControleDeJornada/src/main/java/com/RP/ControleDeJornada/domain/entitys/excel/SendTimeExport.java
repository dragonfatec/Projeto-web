package com.RP.ControleDeJornada.domain.entitys.excel;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import lombok.Data;

@Data
public class SendTimeExport {

    private String data_inicial;
    private String data_final;
    private String tipo_de_hora;
    private String centro_de_resultado;
    private String nome_usuario;
    private String email_usuario;
    private String cliente;
    private double verba_1601;
    private double verba_1602;
    private double verba_1809;
    private double verba_3000;
    private double verba_3001;
    private String justificativa;
    private String status;
//    private String approvedStatus;

    public SendTimeExport(SendTime sendTime){
        this.data_inicial = sendTime.getStartDate().toString();
        this.data_final = sendTime.getFinishDate().toString();
        this.tipo_de_hora = sendTime.getTypeSend().toString();
        this.centro_de_resultado = sendTime.getTeam().getAcronym().toString();
        this.nome_usuario = sendTime.getUser().getName();
        this.email_usuario = sendTime.getUser().getEmail();
        this.cliente = sendTime.getClient().getNameCompany();
        this.verba_1601 = sendTime.getBudget1601();
        this.verba_1602 = sendTime.getBudget1602();
        this.verba_1809 = sendTime.getBudget1809();
        this.verba_3000 = sendTime.getBudget3000();
        this.verba_3001 = sendTime.getBudget3001();
        this.justificativa = sendTime.getJustification();
        this.status = sendTime.getStatus().toString();
//        this.approvedStatus = sendTime.getApprovedStatus().toString();
    }
}
