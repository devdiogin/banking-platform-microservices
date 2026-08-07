package com.banking.ms_auth.amqp.event;

import java.util.UUID;

public record CustomerCreatedEvent(
        UUID id,
        String name,
        String email,
        CustomerStatus status
) {
}
