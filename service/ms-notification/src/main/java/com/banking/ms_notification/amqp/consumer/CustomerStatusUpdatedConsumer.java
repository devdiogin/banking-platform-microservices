package com.banking.ms_notification.amqp.consumer;

import com.banking.ms_notification.amqp.constants.NotificationRabbitConstants;
import com.banking.ms_notification.amqp.event.CustomerStatusUpdateEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerStatusUpdatedConsumer {

    @RabbitListener(queues = NotificationRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
    public void consume(CustomerStatusUpdateEvent event) {
        System.out.println(event);
    }
}
