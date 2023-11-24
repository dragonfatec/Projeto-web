package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RcRepository extends JpaRepository<ResultCenter, String> {


//    @Query(value = "Select" +
//            "s.budget1601 as b1,"+
//            "s.budget1602 as b2," +
//            "s.budget3000 as b3," +
//            "s.budget3001 as b4," +
//            "s.budget1809 as b5" +
//            "FROM tb_sendtime s" +
//            "lEFT JOIN tb_user u ON s.user_registration = u.registration" +
//            "LEFT JOIN tb_user_result_centers urc ON u.registration = urc.user_registration" +
//            "LEFT JOIN tb_result_center rc ON rc.code_rc = urc.result_centers_code_rc" +
//            "group by b1, b2, b3, b4, b5" +
//            "WHERE rc.code_rc = :idResultCenter", nativeQuery = true)
//    public List<SendTime> findTimeByRC(@Param("idResultCenter")String idResultCenter){
//
//    };
}
