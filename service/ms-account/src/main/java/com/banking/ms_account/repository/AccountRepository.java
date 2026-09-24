package com.banking.ms_account.repository;

import com.banking.ms_account.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    Boolean existsByAccountNumber(String account);
    Boolean existsByCustomerId(UUID customerId);
    Optional<AccountEntity> findByCustomerId(UUID customerId);

    @Query("""
            SELECT a.balance from AccountEntity a WHERE a.customerId = :customerId
            """)
    void findByBalance(@Param("customerId") UUID customerId);
}
