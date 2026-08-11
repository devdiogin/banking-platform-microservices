package com.banking.ms_notification.amqp.declaration;

import com.banking.ms_notification.amqp.constants.NotificationRabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationRabbitDeclaration {

    @Bean
    public TopicExchange customerExchange() {
        return ExchangeBuilder
                .topicExchange(NotificationRabbitConstants.CUSTOMER_EXCHANGE)
                .durable(true).build();
    }

    @Bean
    public Queue customerCreatedQueue() {
        return QueueBuilder
                .durable(NotificationRabbitConstants.CUSTOMER_CREATED_QUEUE)
                .build();
    }

    @Bean
    public Binding customerCreatedBinding() {
        return BindingBuilder
                .bind(customerCreatedQueue())
                .to(customerExchange())
                .with(NotificationRabbitConstants.CUSTOMER_CREATED_ROUTING_KEY);
    }

    @Bean
    public Queue customerStatusUpdatedQueue() {
        return QueueBuilder
                .durable(NotificationRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
                .build();
    }

    @Bean Binding customerStatusUpdatedBinding() {
        return BindingBuilder
                .bind(customerStatusUpdatedQueue())
                .to(customerExchange())
                .with(NotificationRabbitConstants.CUSTOMER_STATUS_UPDATED_ROUTING_KEY);
    }
}
