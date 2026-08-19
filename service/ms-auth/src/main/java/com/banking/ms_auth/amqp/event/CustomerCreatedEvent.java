package com.banking.ms_auth.amqp.event;

public record CustomerCreatedEvent(
        String name,
        String legalDocument,
        String email,
        CustomerStatus status
) {
}
