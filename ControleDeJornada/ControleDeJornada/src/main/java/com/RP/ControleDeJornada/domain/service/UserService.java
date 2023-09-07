package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUser;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(RegistrationUserRecord data){
        User user = new User(data);
        userRepository.save(user);
    }

    public void updateUser(Integer id, UpdateUser data){
        User user = userRepository.getReferenceById(id);
        if(data.jobRole() != null){
            user.setJobRole(data.jobRole());
        }
        if (data.resultCenter() != null){
            user.setResultCenter(data.resultCenter());
        }
        if (data.status() != null){
            user.setStatus(data.status());
        }
        userRepository.save(user);
    }

}
