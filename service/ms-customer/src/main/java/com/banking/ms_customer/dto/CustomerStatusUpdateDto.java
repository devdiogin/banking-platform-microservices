package com.banking.ms_customer.dto;

import com.banking.ms_customer.domain.Status;
import jakarta.validation.constraints.NotNull;

public record CustomerStatusUpdateDto(
        @NotNull(message = "Informe o status do cliente.")
        Status status) {
}
