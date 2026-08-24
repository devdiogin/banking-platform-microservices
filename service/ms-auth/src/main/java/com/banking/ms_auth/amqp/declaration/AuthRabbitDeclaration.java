package com.banking.ms_auth.amqp.declaration;

import com.banking.ms_auth.amqp.constants.AuthRabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthRabbitDeclaration {

    @Bean
    public TopicExchange customerExchange() {
        return ExchangeBuilder
                .topicExchange(AuthRabbitConstants.CUSTOMER_EXCHANGE)
                .durable(true).build();
    }

    @Bean
    public Queue customerStatusUpdatedQueue() {
        return QueueBuilder
                .durable(AuthRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
                .build();
    }

    @Bean
    public Binding customerStatusUpdatedBinding() {
        return BindingBuilder
                .bind(customerStatusUpdatedQueue())
                .to(customerExchange())
                .with(AuthRabbitConstants.CUSTOMER_STATUS_UPDATED_ROUTING_KEY);
    }

    @Bean
    public Queue customerCreatedQueue() {
        return QueueBuilder
                .durable(AuthRabbitConstants.CUSTOMER_CREATED_QUEUE)
                .build();
    }

    @Bean
    public Binding customerCreatedBinding() {
        return BindingBuilder
                .bind(customerCreatedQueue())
                .to(customerExchange())
                .with(AuthRabbitConstants.CUSTOMER_CREATED_ROUTING_KEY);
    }
}
