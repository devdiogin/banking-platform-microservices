package com.banking.ms_account.repository;

import com.banking.ms_account.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    Boolean existsByAccountNumber(String account);
}
