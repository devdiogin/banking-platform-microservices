package com.banking.ms_customer.dto;

import com.banking.ms_customer.domain.Status;

import java.time.LocalDate;

public record CustomerSearchDto(
        String name,
        String legalDocument,
        String email,
        LocalDate dateOfBirth,
        Status status
) {
}
