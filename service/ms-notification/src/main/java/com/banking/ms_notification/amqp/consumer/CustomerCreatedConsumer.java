package com.banking.ms_notification.amqp.consumer;

import com.banking.ms_notification.amqp.constants.NotificationRabbitConstants;
import com.banking.ms_notification.amqp.event.CustomerCreatedEvent;
import com.banking.ms_notification.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomerCreatedConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = NotificationRabbitConstants.CUSTOMER_CREATED_QUEUE)
    public void consume(CustomerCreatedEvent event) throws MessagingException, IOException {

        emailService.customerCreated(event.email(), event.name());
    }
}
