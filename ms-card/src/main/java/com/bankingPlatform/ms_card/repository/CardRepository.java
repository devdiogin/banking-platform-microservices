package com.bankingPlatform.ms_card.repository;

import com.bankingPlatform.ms_card.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<CardEntity, UUID> {
}
