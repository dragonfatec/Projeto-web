package com.RP.ControleDeJornada.domain.entitys.relation.clientResulCenter;

import com.RP.ControleDeJornada.domain.entitys.client.Client;
import com.RP.ControleDeJornada.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RCClientService {
    @Autowired
    private ClientService clientService;

    public void addRelation(String cnpj, String codeRc){
        Client client = clientService.getReferenceById(cnpj);
        clientService.addRelationClientRC(client,codeRc);
    }
}
