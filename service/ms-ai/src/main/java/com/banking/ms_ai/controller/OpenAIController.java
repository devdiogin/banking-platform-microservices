package com.banking.ms_ai.controller;

import com.banking.ms_ai.dto.OpenAIRequestDto;
import com.banking.ms_ai.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class OpenAIController {

    private final OpenAIService openAIService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody OpenAIRequestDto dto) {
        return ResponseEntity.ok(openAIService.chat(dto.message()));
    }
}
