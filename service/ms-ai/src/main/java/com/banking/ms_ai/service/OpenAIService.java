package com.banking.ms_ai.service;

import com.banking.ms_ai.Tools.AccountTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAIService {

    private final ChatClient chatClient;
    private final AccountTools accountTools;

    public String chat(String message) {
        return chatClient
                .prompt()
                .user(message)
                .tools(accountTools)
                .call()
                .content();
    }
}
