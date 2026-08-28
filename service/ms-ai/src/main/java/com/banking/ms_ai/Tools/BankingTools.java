package com.banking.ms_ai.Tools;

import com.banking.ms_ai.client.AccountBalanceResponse;
import com.banking.ms_ai.client.AccountClient;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BankingTools {

    private final AccountClient accountClient;

    @Tool(description = "Consultar o saldo da conta bancária do cliente")
    public AccountBalanceResponse getBalance(UUID customerId) {
        return accountClient.getBalance(customerId);
    }
}
