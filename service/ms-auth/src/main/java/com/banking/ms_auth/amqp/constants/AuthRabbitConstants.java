package com.banking.ms_auth.amqp.constants;

public final class AuthRabbitConstants {

    private AuthRabbitConstants() {}

    public static final String CUSTOMER_EXCHANGE = "customer.exchange";

    public static final String CUSTOMER_CREATED_QUEUE = "auth.customer.created.queue";
    public static final String CUSTOMER_CREATED_ROUTING_KEY = "customer.created";

    public static final String CUSTOMER_STATUS_UPDATED_QUEUE = "auth.customer.status.update.queue";
    public static final String CUSTOMER_STATUS_UPDATED_ROUTING_KEY = "customer.status.updated";
}
