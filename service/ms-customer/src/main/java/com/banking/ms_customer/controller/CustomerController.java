package com.banking.ms_customer.controller;

import com.banking.ms_customer.dto.*;
import com.banking.ms_customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Tag(name = "Customer")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Cadastrar novo Cliente")
    @PostMapping
    public ResponseEntity<CustomerResponseDto> insert(@RequestBody @Valid CustomerCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.insert(dto));
    }

    @Operation(summary = "Buscar todos Cliente")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Page<CustomerResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(customerService.findAll(pageable));
    }

    @Operation(summary = "Buscar clientes por Id")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE', 'SUPPORT')")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Operation(summary = "Buscar clientes por valores")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE', 'SUPPORT')")
    @GetMapping("/search")
    public ResponseEntity<Page<CustomerResponseDto>> search(@ModelAttribute CustomerSearchDto dto, @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(customerService.search(dto, pageable));
    }

    @Operation(summary = "Atualizar Status do Cliente")
    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<CustomerResponseDto> updateStatus(@PathVariable UUID id, @RequestBody @Valid CustomerStatusUpdateDto dto) {
        return ResponseEntity.ok(customerService.updateStatus(id, dto));
    }

    @Operation(summary = "Atualizar Dados do Cliente")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('CUSTOMER, ADMIN')")
    public ResponseEntity<CustomerResponseDto> update(@PathVariable UUID id, @Valid CustomerUpdateDto dto) {
        return ResponseEntity.ok(customerService.update(id, dto));
    }

    @Operation(summary = "Inativar cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    @DeleteMapping("/{id}/deactivate")
    public void deactivate(@PathVariable UUID id) {
        customerService.deactivate(id);
    }
}
