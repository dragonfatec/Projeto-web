package com.RP.ControleDeJornada.domain.repository;

import com.RP.ControleDeJornada.domain.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {
    UserDetails findByEmail(String email);
}
