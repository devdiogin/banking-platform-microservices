package com.banking.ms_account.amqp.constants;

public final class AccountRabbitConstants {

    private AccountRabbitConstants() {}

    public static final String EXCHANGE = "customer.exchange";

    public static final String CUSTOMER_CREATED_QUEUE = "account.customer.created.queue";
    public static final String CUSTOMER_CREATED_ROUTING_KEY = "customer.created";

    public static final String CUSTOMER_STATUS_UPDATED_QUEUE = "account.customer.status.updated.queue";
    public static final String CUSTOMER_STATUS_UPDATED_ROUTING_KEY = "customer.status.updated";
}
