package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUserRecord;
import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RcService rcService;

    public void register(RegistrationUserRecord data){
        User user = new User(data);
        ResultCenter rc = rcService.findById(data.codeRc());
        user.setResultCenter(rc);

        userRepository.save(user);
    }

    public void updateUser(Integer id, UpdateUserRecord data){
        User user = userRepository.getReferenceById(id);
        if(data.jobrole() != null){
            user.setJobrole(data.jobrole());
        }
        if (data.codeRc() != null){
            ResultCenter rc = rcService.getReferenceById(data.codeRc());
            user.setResultCenter(rc);
        }
        if (data.status() != null){
            user.setStatus(data.status());
        }
        userRepository.save(user);
    }

    public List<ResultCenter> findAllResultCenter() {
        List<ResultCenter> rc = rcService.findAll();
        return rc;
    }

    public User getUserById(Integer id) {
        User user = userRepository.getReferenceById(id);
        return user;
    }

    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
