package com.banking.ms_ai.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "ms-account")
public interface AccountClient {

    @GetMapping("/account/{customerId}/balance")
    AccountBalanceResponse getBalance(@PathVariable UUID customerId);
}
