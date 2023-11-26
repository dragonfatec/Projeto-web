package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SendTimeRepository extends JpaRepository<SendTime, Integer> {

    Optional<SendTime> findById(Integer idTime);

    List<SendTime> findByUser(User user);

    @Query(value = "select * from tb_sendtime tbs where tbs.team_code_rc = :codeRc and tbs.status = 'WAITING'", nativeQuery = true)
    List<SendTime> findAllByTeam(String codeRc);

    @Query(value = "select * from tb_sendtime tbs where tbs.user_registration = :registration and tbs.team_code_rc = :codeRc and tbs.status = 'WAITING'", nativeQuery = true)
    List<SendTime> getTime(Integer registration, String codeRc);

    @Query(value = "select * from tb_sendtime tbs where tbs.team_code_rc = :codeRc and tbs.status = 'WAITING'", nativeQuery = true)
    List<SendTime> findAllByTeamAndStatusWaiting(String codeRc);

    @Modifying
    @Query(value = "update tb_sendtime tbs set tbs.approved_status = :approvedStatus, tbs.status = :status, tbs.justification = :justification where tbs.id = :id", nativeQuery = true)
    void approvation(@Param("approvedStatus") String approvedStatus, @Param("status") String status, @Param("justification") String justification, @Param("id") Integer id);
}
