package com.banking.ms_account.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.banking.ms_account.dto.AccountResponseDto;
import com.banking.ms_account.dto.AccountUpdateStatusDto;
import com.banking.ms_account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Tag(name = "Account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    @Operation(summary = "Buscar todas contas")
    @PreAuthorize("hasAnyRole('ADMIN', EMPLOYEE, 'SUPORTE')")
    public ResponseEntity<Page<AccountResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(accountService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar contas por Id")
    @PreAuthorize("hasAnyRole('ADMIN', EMPLOYEE, 'SUPORTE')")
    public ResponseEntity<AccountResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.findById(id));
    }

    @GetMapping("/{customerId}/balance")
    @Operation(summary = "Buscar valor disponível na conta")
    @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    public ResponseEntity<AccountResponseDto> findByBalance(@PathVariable UUID customerId) {
        return ResponseEntity.ok(accountService.findByBalance(customerId));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar status da conta")
    @PreAuthorize("hasAnyRole('ADMIN', EMPLOYEE, 'SUPORTE')")
    public ResponseEntity<AccountResponseDto> updateStatus(@PathVariable UUID id, @RequestBody AccountUpdateStatusDto dto) {
        return ResponseEntity.ok(accountService.updateStatus(id, dto));
    }
}
