package com.RP.ControleDeJornada.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record RegistrationClientRecord(
        @CNPJ
        StringBuilder cnpj,
        @NotBlank
        StringBuilder razaoSocial,
        @NotBlank
        StringBuilder nameCompany
){}
