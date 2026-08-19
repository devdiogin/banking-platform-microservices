package com.banking.ms_customer.amqp.event;

import com.banking.ms_customer.domain.Status;

public record CustomerCreatedEvent(
        String name,
        String legalDocument,
        String email,
        Status status
) {
}
