package com.banking.ms_notification.amqp.constants;

public final class NotificationRabbitConstants {

    private NotificationRabbitConstants() {}

    public static final String CUSTOMER_EXCHANGE = "customer.exchange";

    public static final String CUSTOMER_CREATED_QUEUE = "notification.customer.created.queue";
    public static final String CUSTOMER_CREATED_ROUTING_KEY = "customer.created";

    public static final String CUSTOMER_STATUS_UPDATED_QUEUE = "notification.customer.status.update.queue";
    public static final String CUSTOMER_STATUS_UPDATED_ROUTING_KEY = "customer.status.updated";
}
