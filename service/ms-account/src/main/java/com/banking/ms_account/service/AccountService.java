package com.banking.ms_account.service;

import com.banking.ms_account.amqp.event.CustomerStatusUpdateEvent;
import com.banking.ms_account.domain.AccountEntity;
import com.banking.ms_account.domain.AccountStatus;
import com.banking.ms_account.domain.AccountType;
import com.banking.ms_account.dto.AccountResponseDto;
import com.banking.ms_account.dto.AccountUpdateStatusDto;
import com.banking.ms_account.exception.AccountNotFoundException;
import com.banking.ms_account.mapper.AccountMapper;
import com.banking.ms_account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private static final String ACCOUNT_NOT_FOUND = "Conta não encontrada";

    @Transactional
    public void insert(CustomerStatusUpdateEvent event) {
        if (Boolean.TRUE.equals(accountRepository.existsByCustomerId(event.id()))) {
            return;
        }

        var account = AccountEntity.builder()
                .customerId(event.id())
                .accountNumber(generateAccountNumber())
                .digit(generateDigit())
                .type(AccountType.CHECKING)
                .status(AccountStatus.ACTIVE)
                .build();

        accountRepository.save(account);
    }

    @Transactional(readOnly = true)
    public Page<AccountResponseDto> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable)
                .map(accountMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public AccountResponseDto findById(UUID id) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(ACCOUNT_NOT_FOUND));

        return accountMapper.toResponse(account);
    }

    @Transactional(readOnly = true)
    public AccountResponseDto findByBalance(UUID customerId) {
        var account = accountRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new AccountNotFoundException(ACCOUNT_NOT_FOUND));

        accountRepository.findByBalance(account.getBalance());
        return accountMapper.toResponse(account);
    }

    @Transactional
    public AccountResponseDto updateStatus(UUID id, AccountUpdateStatusDto dto) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(ACCOUNT_NOT_FOUND));

        account.setStatus(dto.status());
        return accountMapper.toResponse(account);
    }


    private String generateAccountNumber() {
        String accountNumber;

        do {
            int number = ThreadLocalRandom.current().nextInt(10_000_000, 100_000_000);

            accountNumber = String.valueOf(number);

        } while (Boolean.TRUE.equals(accountRepository.existsByAccountNumber(accountNumber)));
            return accountNumber;
    }

    private String generateDigit() {
        return String.valueOf(ThreadLocalRandom.
                current()
                .nextInt(0, 10));
    }
}
