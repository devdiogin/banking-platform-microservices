package com.banking.ms_auth.amqp.consumer;

import com.banking.ms_auth.amqp.constants.AuthRabbitConstants;
import com.banking.ms_auth.amqp.event.CustomerCreatedEvent;
import com.banking.ms_auth.service.KeycloakUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerCreatedConsumer {

    private final KeycloakUserService keycloakUserService;

    @RabbitListener(queues = AuthRabbitConstants.CUSTOMER_CREATED_QUEUE)
    public void consume(CustomerCreatedEvent event) {
        keycloakUserService.createUser(event);
    }
}
