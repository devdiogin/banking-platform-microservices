package com.banking.ms_customer.amqp.event;

import com.banking.ms_customer.domain.Status;

import java.util.UUID;

public record CustomerCreatedEvent(
        UUID id,
        String name,
        String email,
        Status status
) {
}
