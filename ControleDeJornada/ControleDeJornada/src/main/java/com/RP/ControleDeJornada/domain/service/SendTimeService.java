package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.ResgistrationSendTimeRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendTimeService {

    @Autowired
    private SendTypeRepository repository;
    @Autowired
    private RcRepository rcService;
    @Autowired
    private UserRepository userService;

    public void saveTime(ResgistrationSendTimeRecord data) {
        SendTime time = new SendTime(data);
        ResultCenter rc = rcService.getReferenceById(data.codeRc());
        time.setTeam(rc);
        User user = userService.getReferenceById(data.idUser());
        time.setUser(user);
        repository.save(time);
    }

    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    public List<ResultCenter> getAllResult() {
        List<ResultCenter> rcs = rcService.findAll();
        return rcs;
    }


    public List<SendTime> findAllSendTime() {
        List<SendTime> sendTimes = repository.findAll();
        return sendTimes;
    }
}
