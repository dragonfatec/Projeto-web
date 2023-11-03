package com.RP.ControleDeJornada.domain.entitys.user;

import com.RP.ControleDeJornada.domain.Status;
import com.RP.ControleDeJornada.domain.dto.RegistrationUserRecord;
import com.RP.ControleDeJornada.domain.entitys.relation.userResultCenter.RelationUserRC;
import com.RP.ControleDeJornada.domain.entitys.resultCenter.ResultCenter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registration;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private JobRole jobrole;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate createDate;
    private LocalDate updateUser;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RelationUserRC> relation;

    public User(RegistrationUserRecord data){
        this.name = data.name().toUpperCase().trim();
        this.email = data.email();
        this.jobrole = data.jobrole();
        this.status = Status.ACTIVE;
        this.createDate = LocalDate.now();
        this.updateUser = LocalDate.now();
    }

    public void addRelation(RelationUserRC rurc){
        rurc.setUser(this);
        this.relation.add(rurc);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.jobrole == JobRole.ADMINISTRADOR) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"), new SimpleGrantedAuthority("ROLE_USER"));
        }else if (this.jobrole == JobRole.MANAGER){
            return List.of(new SimpleGrantedAuthority("ROLE_MANAGER"), new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
