package com.banking.ms_customer.dto;

import com.banking.ms_customer.domain.Status;
import jakarta.validation.constraints.Email;

public record CustomerUpdateDto(
        @Email
        String email,
        Status status,
        AddressDto addressDto
) {
}
