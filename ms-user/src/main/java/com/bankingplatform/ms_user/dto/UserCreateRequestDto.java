package com.bankingplatform.ms_user.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserCreateRequestDto(
        @NotBlank String fullName,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotBlank @Email String email,
        @NotBlank String phone,
        @Past @NotNull LocalDate birthDate
) {
}
