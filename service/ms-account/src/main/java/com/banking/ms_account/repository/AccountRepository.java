package com.banking.ms_account.repository;

import com.banking.ms_account.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    Boolean existsByAccountNumber(String account);
    Boolean existsByCustomerId(UUID customerId);
    Optional<AccountEntity> findByBalance(BigDecimal balance);
    Optional<AccountEntity> findByCustomerId(UUID customerId);
}
