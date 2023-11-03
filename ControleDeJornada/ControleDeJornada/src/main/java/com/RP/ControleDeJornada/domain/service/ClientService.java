package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter.RelationRCClient;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.repository.ClientRepository;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RcRepository rcRepository;

    public void register(RegistrationClientRecord data){
        Client client = new Client(data);
        clientRepository.save(client);
    }

    public List<Client> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public void addRelationClientRC(Client client, String codeRc){
        ResultCenter resultCenter = rcRepository.getReferenceById(codeRc);
        RelationRCClient rrcc = new RelationRCClient(client, resultCenter);
        client.addRelation(rrcc);
    }


    public Client getReferenceById(String cnpj) {
        Client client = clientRepository.getReferenceById(cnpj);
        return client;
    }
}
