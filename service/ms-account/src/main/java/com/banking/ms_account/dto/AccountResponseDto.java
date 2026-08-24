package com.banking.ms_account.dto;

import com.banking.ms_account.domain.AccountStatus;
import com.banking.ms_account.domain.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountResponseDto(
        UUID id,
        UUID customerId,
        String agency,
        String accountNumber,
        String digit,
        String bank,
        String bankName,
        AccountType type,
        BigDecimal balance,
        AccountStatus status
) {
}
