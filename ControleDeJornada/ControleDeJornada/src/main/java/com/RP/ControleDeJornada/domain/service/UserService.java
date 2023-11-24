package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.ModifierRelationUserRCRecord;
import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.dto.UpdateUserRecord;
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

    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("admin",BCrypt.gensalt()));
    }

    public void register(RegistrationUserRecord data){
        User user = new User(data);

        String passwordCript = BCrypt.hashpw(data.password(),BCrypt.gensalt());
        user.setPassword(passwordCript);

        userRepository.save(user);
    }

    public void updateUser(UpdateUserRecord data){
        User user = userRepository.getReferenceById(data.registration());
        if(data.jobRole() != null){
            user.setJobrole(data.jobRole());
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
        if (data.email() != null){
            user.setEmail(data.email());
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

    public User getReferenceById(Integer register) {
        User user = userRepository.getReferenceById(register);
        return user;
    }

    public void deleteRelation(ModifierRelationUserRCRecord data) {
        userRepository.deleteRelation(data.registration(), data.codeRc());
    }
}
