package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationClientRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateClientRecord;
import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void register(RegistrationClientRecord data){
        Client client = new Client(data);
        clientRepository.save(client);
    }

    public List<Client> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public Client getReferenceById(String cnpj) {
        Client client = clientRepository.getReferenceById(cnpj);
        return client;
    }

    public void updateClient(String cnpj, UpdateClientRecord data) {
        Client client = clientRepository.getReferenceById(cnpj);
        if (data.officialName() != null) {
            client.setOfficialName(data.officialName());
        }
        if (data.nameCompany() != null) {
            client.setNameCompany(data.nameCompany());
        }
        if (data.status() != null) {
            client.setStatus(data.status());
        }
        client.setUpdateClient(LocalDate.now());
        clientRepository.save(client);
    }
}
