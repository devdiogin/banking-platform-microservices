package com.banking.ms_auth.amqp.consumer;

import com.banking.ms_auth.amqp.constants.AuthRabbitConstants;
import com.banking.ms_auth.amqp.event.CustomerStatusUpdateEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerStatusUpdatedConsumer {

    @RabbitListener(queues = AuthRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
    public void consume(CustomerStatusUpdateEvent event) {
    }
}
