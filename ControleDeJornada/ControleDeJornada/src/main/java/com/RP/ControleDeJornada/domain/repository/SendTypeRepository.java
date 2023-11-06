package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SendTypeRepository extends JpaRepository<SendTime, Integer> {

    Optional<SendTime> findById(Integer idTime);

    List<SendTime> findByUser(User user);

    @Query("SELECT " +
                "sum(s.budget1601) as b1, " +
                "sum (s.budget1602) as b2, " +
                "sum(s.budget3000) as b3, " +
                "sum(s.budget1809) as b4, " +
                "sum(s.budget3001) as b5 " +
            "FROM " +
                "SendTime s " +
            "WHERE " +
                "s.user = :user")
    List<SendTime> findSendTimesByUser(@Param("user") User user);
}
