package com.banking.ms_customer.amqp.constants;

public final class CustomerRabbitConstants {

    private CustomerRabbitConstants() {}

    public static final String EXCHANGE = "customer.exchange";

    public static final String CUSTOMER_CREATED_ROUTING_KEY = "customer.created";
    public static final String CUSTOMER_STATUS_UPDATED_ROUTING_KEY = "customer.status.updated";
}
