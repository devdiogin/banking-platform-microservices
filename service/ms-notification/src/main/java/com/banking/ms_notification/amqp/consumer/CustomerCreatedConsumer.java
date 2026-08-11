package com.banking.ms_notification.amqp.consumer;

import com.banking.ms_notification.amqp.constants.NotificationRabbitConstants;
import com.banking.ms_notification.amqp.event.CustomerCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreatedConsumer {

    @RabbitListener(queues = NotificationRabbitConstants.CUSTOMER_CREATED_QUEUE)
    public void consume(CustomerCreatedEvent event) {
        System.out.println(event);
    }
}
