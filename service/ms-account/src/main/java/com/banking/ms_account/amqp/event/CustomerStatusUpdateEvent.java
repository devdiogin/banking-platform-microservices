package com.banking.ms_account.amqp.event;

import java.util.UUID;

public record CustomerStatusUpdateEvent(
        UUID id,
        CustomerStatus status) {
}
