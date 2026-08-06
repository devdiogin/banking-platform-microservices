package com.banking.ms_customer.repository;

import com.banking.ms_customer.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByLegalDocument(String legalDocument);
    boolean existsByEmailIgnoreCase(String email);

//    @Query("""
//    SELECT c
//    FROM CustomerEntity c
//    WHERE (:name IS NULL
//           OR LOWER(c.name) LIKE CONCAT('%', LOWER(:name), '%'))
//      AND (:legalDocument IS NULL
//           OR c.legalDocument = :legalDocument)
//      AND (:email IS NULL
//           OR LOWER(c.email) = LOWER(:email))
//      AND (:dateOfBirth IS NULL
//           OR c.dateOfBirth = :dateOfBirth)
//      AND (:status IS NULL
//           OR c.status = :status)
//    """)
//    Page<CustomerEntity> search(
//            @Param("name") String name,
//            @Param("legalDocument") String legalDocument,
//            @Param("email") String email,
//            @Param("dateOfBirth") LocalDate dateOfBirth,
//            @Param("status") Status status,
//            Pageable pageable
//    );
}
