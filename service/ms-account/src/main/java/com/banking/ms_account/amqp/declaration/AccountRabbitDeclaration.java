package com.banking.ms_account.amqp.declaration;

import com.banking.ms_account.amqp.constants.AccountRabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountRabbitDeclaration {

    @Bean
    public TopicExchange customerExchange() {
        return ExchangeBuilder
                .topicExchange(AccountRabbitConstants.EXCHANGE)
                .durable(true).build();
    }

    @Bean
    public Queue AccountStatusUpdatedQueue() {
        return QueueBuilder
                .durable(AccountRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
                .build();
    }

    @Bean
    public Binding AccountStatusUpdatedBinding() {
        return BindingBuilder
                .bind(AccountStatusUpdatedQueue())
                .to(customerExchange())
                .with(AccountRabbitConstants.CUSTOMER_STATUS_UPDATED_ROUTING_KEY);
    }
}
