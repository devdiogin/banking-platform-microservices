package com.banking.ms_customer.amqp.producer;

import com.banking.ms_customer.amqp.constants.CustomerRabbitConstants;
import com.banking.ms_customer.amqp.event.CustomerStatusUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public void publishCustomerStatusUpdated(CustomerStatusUpdatedEvent eventProducer) {
        rabbitTemplate.convertAndSend(
                CustomerRabbitConstants.EXCHANGE,
                CustomerRabbitConstants.CUSTOMER_STATUS_UPDATED_ROUTING_KEY,
                eventProducer
        );
    }
}
