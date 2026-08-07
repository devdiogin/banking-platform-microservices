package com.banking.ms_auth.amqp.consumer;

import com.banking.ms_auth.amqp.constants.AuthRabbitConstants;
import com.banking.ms_auth.amqp.event.CustomerCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreatedConsumer {

    @RabbitListener(queues = AuthRabbitConstants.CUSTOMER_CREATED_QUEUE)
    public void consume(CustomerCreatedEvent event) {
        System.out.println(event);
    }
}
