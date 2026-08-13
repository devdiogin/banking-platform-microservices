package com.banking.ms_auth.amqp.event;

import java.util.UUID;

public record CustomerStatusUpdateEvent(
        UUID id,
        String username,
        String email,
        CustomerStatus status) {
}
