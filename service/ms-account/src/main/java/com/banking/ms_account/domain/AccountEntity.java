package com.banking.ms_account.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AccountEntity {

    private static final Clock CLOCK = Clock.systemDefaultZone();

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID customerId;

    @Builder.Default
    @Column(nullable = false)
    private String agency = "2511";

    @Column(nullable = false, unique = true, length = 8)
    private String accountNumber;

    @Column(nullable = false)
    private String digit;

    @Builder.Default
    @Column(nullable = false)
    private String bank = "0001";

    @Builder.Default
    @Column(nullable = false)
    private String bankName = "Spring Bank";

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now(CLOCK);
        updatedAt = LocalDateTime.now(CLOCK);
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = LocalDateTime.now(CLOCK);
    }
}
