package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationTeamRecord;
import com.RP.ControleDeJornada.domain.entidades.time.Team;
import com.RP.ControleDeJornada.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void salvar(RegistrationTeamRecord dados){
        Team team = new Team(dados);
        teamRepository.save(team);
    }
}
