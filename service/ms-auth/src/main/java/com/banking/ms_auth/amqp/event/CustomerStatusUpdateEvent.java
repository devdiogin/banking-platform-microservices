package com.banking.ms_auth.amqp.event;

public record CustomerStatusUpdateEvent(
        String name,
        String legalDocument,
        String email,
        CustomerStatus status) {
}
