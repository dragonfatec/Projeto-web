package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUserRecord;
import com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter.RelationUserRC;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RcService rcService;

    public void register(RegistrationUserRecord data){
        User user = new User(data);

        String passwordCript = BCrypt.hashpw(data.password(),BCrypt.gensalt());
        user.setPassword(passwordCript);

        userRepository.save(user);
    }

    public void updateUser(Integer id, UpdateUserRecord data){
        User user = userRepository.getReferenceById(id);
        if(data.jobRole() != null){
            user.setJobrole(data.jobRole());
        }
        if (data.registration() != null && data.codeRc() != null){
            User newUser = userRepository.getReferenceById(data.registration());
            ResultCenter newRc = rcService.getReferenceById(data.codeRc());

            RelationUserRC userResultCenter = new RelationUserRC(newUser, newRc);
            List<RelationUserRC> list = new ArrayList<>();
            list.add(userResultCenter);
        }
        if (data.status() != null){
            user.setStatus(data.status());
        }
        if (data.name() != null){
            user.setName(data.name());
        }
        if (data.password() != null){
            String passwordCript = BCrypt.hashpw(data.password(),BCrypt.gensalt());
            user.setPassword(passwordCript);
        }
        user.setUpdateUser(LocalDate.now());
        userRepository.save(user);
    }

    public List<ResultCenter> findAllResultCenter() {
        List<ResultCenter> rc = rcService.findAll();
        return rc;
    }

    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User findByRegistration(Integer registration) {
        User user = userRepository.findByRegistration(registration);
        return  user;
    }


}
