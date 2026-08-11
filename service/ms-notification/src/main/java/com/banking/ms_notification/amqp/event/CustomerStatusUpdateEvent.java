package com.banking.ms_notification.amqp.event;

import java.util.UUID;

public record CustomerStatusUpdateEvent(
        UUID id,
        CustomerStatus status) {
}
