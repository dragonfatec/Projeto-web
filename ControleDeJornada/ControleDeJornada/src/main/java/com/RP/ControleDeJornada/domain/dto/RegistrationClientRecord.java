package com.RP.ControleDeJornada.domain.dto;


import jakarta.validation.constraints.NotBlank;

public record RegistrationClientRecord(
        @NotBlank
        String cnpj,
        @NotBlank
        String razaoSocial,
        @NotBlank
        String nameCompany
){}
