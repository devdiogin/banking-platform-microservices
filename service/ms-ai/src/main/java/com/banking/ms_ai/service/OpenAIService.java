package com.banking.ms_ai.service;

import com.banking.ms_ai.Tools.BankingTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAIService {

    private final ChatClient chatClient;
    private final BankingTools bankingTools;

    public String chat(String message) {
        return chatClient
                .prompt()
                .user(message)
                .tools(bankingTools)
                .call()
                .content();
    }
}
