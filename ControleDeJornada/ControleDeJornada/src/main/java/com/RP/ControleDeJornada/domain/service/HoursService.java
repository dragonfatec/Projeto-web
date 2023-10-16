package com.RP.ControleDeJornada.domain.service;

import com.RP.ControleDeJornada.domain.dto.DataListingTime;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoursService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SendTypeRepository hoursRepository;
    public ResponseEntity<List<DataListingTime>> viewHoursForCollaborator(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Integer userId = user.get().getId();
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                List<SendTime> userHours = hoursRepository.findByUser(userOptional.get());
                return ResponseEntity.ok(userHours.stream().map(sendTime -> new DataListingTime(sendTime)).toList());
            }
        }
        return ResponseEntity.notFound().build();
    }
}
