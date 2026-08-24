package com.banking.ms_account.amqp.consumer;

import com.banking.ms_account.amqp.constants.AccountRabbitConstants;
import com.banking.ms_account.amqp.event.CustomerStatus;
import com.banking.ms_account.amqp.event.CustomerStatusUpdateEvent;
import com.banking.ms_account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerStatusUpdatedConsume {

    private final AccountService accountService;

    @RabbitListener(queues = AccountRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
    public void consume(CustomerStatusUpdateEvent event) {

        if (event.status() == CustomerStatus.ACTIVE) {
            accountService.insert(event);
        }
    }
}
