package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.user.RelationUserResultCenter;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Objects;

public interface UserRepository extends JpaRepository<User, Integer> {
    UserDetails findByEmail(String email);
    User findByRegistration(Integer registration);
    @Query(value = "select urc.user_registration, u.name, urc.result_centers_code_rc from tb_user_result_centers urc join tb_user u on u.registration = urc.user_registration where urc.result_centers_code_rc = :codeRc", nativeQuery = true)
    List<Object[]> findByResultCenter(@Param("codeRc") String codeRc);
    @Query(value = "select crc.client_cnpj, crc.result_center_code_rc, rc.rc from tb_client_result_center crc join tb_result_center rc on rc.code_rc = crc.result_center_code_rc where crc.client_cnpj = :cnpj", nativeQuery = true)
    List<Object[]> findByClient(@Param("cnpj") String cnpj);

    @Modifying
    @Query(value = "delete from tb_user_result_centers urc WHERE urc.user_registration = :registration and urc.result_centers_code_rc = :codeRc", nativeQuery = true)
    void deleteRelation(@Param("registration") Integer registration, @Param("codeRc") String codeRc);
}
