package com.banking.ms_notification.amqp.event;

public record CustomerCreatedEvent(
        String name,
        String email
) {
}
