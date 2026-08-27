package com.banking.ms_ai.controller;

import com.banking.ms_ai.dto.OpenAIRequestDto;
import com.banking.ms_ai.service.OpenAIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
@Tag(name = "Controller AI")
public class OpenAIController {

    private final OpenAIService openAIService;

    @PostMapping("/chat")
    @Operation(summary = "Realizar a Busca com Chat")
    public ResponseEntity<String> chat(@RequestBody OpenAIRequestDto dto) {
        return ResponseEntity.ok(openAIService.chat(dto.message()));
    }
}
