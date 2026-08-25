package com.banking.ms_notification.amqp.consumer;

import com.banking.ms_notification.amqp.constants.NotificationRabbitConstants;
import com.banking.ms_notification.amqp.event.CustomerStatusUpdateEvent;
import com.banking.ms_notification.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomerStatusUpdatedConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = NotificationRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
    public void consume(CustomerStatusUpdateEvent event) throws MessagingException, IOException {
        emailService.customerStatusUpdate(event);
    }
}