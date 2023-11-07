package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.dto.ShowSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.Parameterization;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.ClientRepository;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SendTimeService {

    @Autowired
    private SendTypeRepository repository;
    @Autowired
    private RcRepository rcService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userService;

    public void saveTime(ResgistrationSendTimeRecord data) {
        SendTime time = new SendTime(data);
        ResultCenter rc = rcService.getReferenceById(data.resultCenters());
        time.setTeam(rc);
        User user = userService.getReferenceById(Integer.parseInt(data.registration()));
        time.setUser(user);
        Client client = clientRepository.getReferenceById(data.client());
        time.setClient(client);
        Parameterization parameterization = new Parameterization(data.startDate(), data.finishDate());
        time.setBudget1601(parameterization.getBudget1601());
        time.setBudget1602(parameterization.getBudget1602());
        time.setBudget1809(parameterization.getBudget1809());
        time.setBudget3000(parameterization.getBudget3000());
        time.setBudget3001(parameterization.getBudget3001());
        repository.save(time);
    }

    public List<Client> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public List<ResultCenter> getAllResult() {
        List<ResultCenter> rcs = rcService.findAll();
        return rcs;
    }

    public List<ShowSendTimeRecord> findAllSendTime() {
        List<SendTime> sendTimes = repository.findAll();
        List<ShowSendTimeRecord> sendTimeDTO = new ArrayList<>();
        for(SendTime sendTime : sendTimes ){
            ShowSendTimeRecord dto = new ShowSendTimeRecord(
                    sendTime.getUser().getName(),
                    sendTime.getStartDate(),
                    sendTime.getFinishDate(),
                    sendTime.getTypeSend().toString(),
                    sendTime.getStatus().toString(),
                    sendTime.getApprovedStatus().toString(),
                    sendTime.getJustification());

            sendTimeDTO.add(dto);
        }

        return sendTimeDTO;
    }

    public List<ResultCenter> getRCByClients(String cnpj) {
        Client client = clientRepository.getReferenceById(cnpj);
        return client.getResultCenter();
    }
}
