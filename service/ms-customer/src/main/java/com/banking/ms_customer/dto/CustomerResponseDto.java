package com.banking.ms_customer.dto;

import java.time.LocalDate;

public record CustomerResponseDto(
        String name,
        String legalDocument,
        String email,
        LocalDate dateOfBirth
) {
}
