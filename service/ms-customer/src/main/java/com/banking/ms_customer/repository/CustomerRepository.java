package com.banking.ms_customer.repository;

import com.banking.ms_customer.model.CustomerEntity;
import com.banking.ms_customer.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByLegalDocument(String document);
    boolean existsByEmail(String email);
    List<CustomerEntity> findByNameContainingIgnoreCase(String search);
    List<CustomerEntity> findByStatus(Status status);
    Optional<CustomerEntity> findByLegalDocument(String legalDocument);
    Optional<CustomerEntity> findByEmail(String email);
}
