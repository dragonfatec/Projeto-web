package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, String> {
    @Modifying
    @Query(value = "delete from tb_client_result_center where client_cnpj = :cnpj and result_center_code_rc = :codeRc", nativeQuery = true)
    void deleteRelation(@Param("cnpj") String cnpj,@Param("codeRc") String codeRc);
}
