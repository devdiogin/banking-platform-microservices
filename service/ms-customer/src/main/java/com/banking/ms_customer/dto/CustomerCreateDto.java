package com.banking.ms_customer.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CustomerCreateDto(
        @NotBlank(message = "Informe o Nome")
        String name,

        @NotBlank(message = "Informe o CPF.")
        @CPF
        String legalDocument,

        @NotBlank(message = "Informe o E-mail")
        @Email
        String email,

        @NotNull(message = "Informe a Data de Nascimento.")
        @PastOrPresent(message = "A data de nascimento não pode ser uma data futura.")
        LocalDate dateOfBirth,

        @Valid
        @NotNull(message = "Informe o endereço")
        AddressDto address
) {
}
