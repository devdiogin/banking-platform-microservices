package com.bankingplatform.ms_user.dto;

import com.bankingplatform.ms_user.model.StatusUser;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String fullName,
        String cpf,
        String email,
        String phone,
        LocalDate birthDate,
        StatusUser status,
        Instant createdAt
) {
}
