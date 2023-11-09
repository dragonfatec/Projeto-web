package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RcRepository extends JpaRepository<ResultCenter, String> {


//    @Query("SELECT " +
//            "sum(s.budget1601) as b1, " +
//            "sum (s.budget1602) as b2, " +
//            "sum(s.budget3000) as b3, " +
//            "sum(s.budget1809) as b4, " +
//            "sum(s.budget3001) as b5 " +
//            "FROM " +
//            "User us " +
//            "INNER JOIN tb_user_result_centers"
//            "WHERE " +
//            "s.user = :idResultCenter"))
//    public List<SendTime> findTimeByRC(@Param("idResultCenter")ResultCenter idResultCenter){};
}
