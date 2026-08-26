package com.banking.ms_auth.amqp.consumer;

import com.banking.ms_auth.amqp.constants.AuthRabbitConstants;
import com.banking.ms_auth.amqp.event.CustomerStatus;
import com.banking.ms_auth.amqp.event.CustomerStatusUpdateEvent;
import com.banking.ms_auth.service.KeycloakUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerStatusUpdatedConsumer {

    private final KeycloakUserService keycloakUserService;

    @RabbitListener(queues = AuthRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
    public void consume(CustomerStatusUpdateEvent event) {

        if (event.status() == CustomerStatus.ACTIVE) {
            keycloakUserService.enableUser(event.legalDocument());
        }
    }
}
