package com.bankingplatform.ms_user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UserUpdateRequestDto(
    @Email String email,
    @Pattern(regexp = "\\d{11}") String phone
) {
}
