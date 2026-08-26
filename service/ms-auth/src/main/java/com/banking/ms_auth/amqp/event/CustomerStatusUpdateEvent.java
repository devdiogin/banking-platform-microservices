package com.banking.ms_auth.amqp.event;

public record CustomerStatusUpdateEvent(
        String legalDocument,
        CustomerStatus status) {
}
