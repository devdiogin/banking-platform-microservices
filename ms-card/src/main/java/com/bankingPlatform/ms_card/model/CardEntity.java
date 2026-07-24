package com.bankingPlatform.ms_card.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CardEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID accountId;

    @Column(nullable = false, unique = true, length = 16)
    private String cardNumber;

    @Column(nullable = false, length = 100)
    private String cardholderName;

    @Column(nullable = false, length = 3)
    private String cvv;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCard type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCard status;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}
