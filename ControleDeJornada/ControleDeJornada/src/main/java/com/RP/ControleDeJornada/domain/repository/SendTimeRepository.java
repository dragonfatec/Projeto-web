package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface SendTimeRepository extends JpaRepository<SendTime, Integer> {

    Optional<SendTime> findById(Integer idTime);

    List<SendTime> findByUser(User user);

    @Query("SELECT 'Budget 1601', SUM(s.budget1601) " +
            "FROM SendTime s WHERE s.user = :user " +
            "UNION " +
            "SELECT 'Budget 1602', SUM(s.budget1602) " +
            "FROM SendTime s WHERE s.user = :user " +
            "UNION " +
            "SELECT 'Budget 3000', SUM(s.budget3000) " +
            "FROM SendTime s WHERE s.user = :user " +
            "UNION " +
            "SELECT 'Budget 1809', SUM(s.budget1809) " +
            "FROM SendTime s WHERE s.user = :user " +
            "UNION " +
            "SELECT 'Budget 3001', SUM(s.budget3001) " +
            "FROM SendTime s WHERE s.user = :user")
    List<Object[]> findSendTimesByUser(@Param("user") User user);

    @Query(value = "select * from tb_sendtime where team_code_rc = :codeRc", nativeQuery = true)
    List<SendTime> findAllByTeam(String codeRc);

    @Query(value = "select * from tb_sendtime tbs where tbs.user_registration = :registration and tbs.team_code_rc = :codeRc", nativeQuery = true)
    List<SendTime> getTime(Integer registration, String codeRc);

    @Query(value = "select * from tb_sendtime tbs where tbs.team_code_rc = :codeRc and tbs.status = 'WAITING'", nativeQuery = true)
    List<SendTime> findAllByTeamAndStatusWaiting(String codeRc);
}
