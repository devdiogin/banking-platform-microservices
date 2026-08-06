package com.banking.ms_customer.amqp.declaration;

import com.banking.ms_customer.amqp.constants.CustomerRabbitConstants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRabbitDeclaration {

    @Bean
    public TopicExchange customerTopicExchange() {
        return ExchangeBuilder
                .topicExchange(CustomerRabbitConstants.EXCHANGE)
                .durable(true)
                .build();
    }
}
