package com.RP.ControleDeJornada.domain.dto;

import com.RP.ControleDeJornada.domain.entitys.user.JobRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.security.SecureRandom;

public record RegistrationUserRecord(
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String password,
        @NotNull
        JobRole jobrole,
        @NotBlank
        String codeRc) {
}
