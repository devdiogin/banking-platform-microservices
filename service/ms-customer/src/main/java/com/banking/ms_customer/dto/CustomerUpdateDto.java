package com.banking.ms_customer.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

public record CustomerUpdateDto(
        @Email(message = "Informe um e-mail válido")
        String email,
        @Valid
        AddressDto addressDto
) {
}
