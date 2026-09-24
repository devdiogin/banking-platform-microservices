package com.banking.ms_account.amqp.consumer;

import com.banking.ms_account.amqp.constants.AccountRabbitConstants;
import com.banking.ms_account.amqp.event.CustomerStatus;
import com.banking.ms_account.amqp.event.CustomerStatusUpdateEvent;
import com.banking.ms_account.domain.AccountStatus;
import com.banking.ms_account.dto.AccountUpdateStatusDto;
import com.banking.ms_account.exception.AccountNotFoundException;
import com.banking.ms_account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerStatusUpdatedConsume {

    private final AccountService accountService;

    private static final String ACCOUNT_NOT_FOUND = "Conta não encontrada.";

    @RabbitListener(queues = AccountRabbitConstants.CUSTOMER_STATUS_UPDATED_QUEUE)
    public void consume(CustomerStatusUpdateEvent event) {

        var account = accountService.findByCustomerId(event.id());

        if (event.status() == CustomerStatus.ACTIVE) {
            if (account == null) {
                accountService.insert(event);
                return;
            }

            accountService.updateStatus(account.id(), new AccountUpdateStatusDto(AccountStatus.ACTIVE));
            return;
        }

        if (event.status() == CustomerStatus.BLOCKED) {
            if (account == null) {
                throw new AccountNotFoundException(ACCOUNT_NOT_FOUND);
            }
            accountService.blockAccount(event);
        }
    }
}
