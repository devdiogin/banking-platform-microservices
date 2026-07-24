package com.bankingPlatform.ms_card.service;

import com.bankingPlatform.ms_card.mapper.CardMapper;
import com.bankingPlatform.ms_card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
}
