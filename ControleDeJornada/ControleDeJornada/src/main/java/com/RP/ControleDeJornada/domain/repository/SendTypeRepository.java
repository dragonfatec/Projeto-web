package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SendTypeRepository extends JpaRepository<SendTime, String> {

    Optional<SendTime> findById(Integer idTime);

    List<SendTime> findByUser(User user);
}
