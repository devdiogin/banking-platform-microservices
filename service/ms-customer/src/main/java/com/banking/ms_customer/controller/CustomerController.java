package com.banking.ms_customer.controller;

import com.banking.ms_customer.dto.CustomerCreateDto;
import com.banking.ms_customer.dto.CustomerResponseDto;
import com.banking.ms_customer.dto.CustomerSearchDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Operation(summary = "Paginação de todos clientes")
    @GetMapping
    public ResponseEntity<Page<CustomerResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(customerService.findAll(pageable));
    }

    @Operation(summary = "Buscar clientes por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Operation(summary = "Buscar clientes")
    @GetMapping("/search/{search}")
    public ResponseEntity<List<CustomerResponseDto>> search(@PathVariable CustomerSearchDto search) {
        return ResponseEntity.ok(customerService.search(search));
    }
}
