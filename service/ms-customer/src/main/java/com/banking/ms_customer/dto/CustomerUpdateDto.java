package com.banking.ms_customer.dto;

import jakarta.validation.constraints.Email;

public record CustomerUpdateDto(
        @Email
        String email,
        AddressDto addressDto
) {
}
