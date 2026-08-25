package com.banking.ms_customer.service;

import com.banking.ms_customer.amqp.event.CustomerCreatedEvent;
import com.banking.ms_customer.amqp.event.CustomerStatusUpdatedEvent;
import com.banking.ms_customer.amqp.producer.CustomerEventProducer;
import com.banking.ms_customer.domain.Status;
import com.banking.ms_customer.dto.*;
import com.banking.ms_customer.exception.CustomerConflictException;
import com.banking.ms_customer.exception.CustomerNotFoundException;
import com.banking.ms_customer.mapper.CustomerMapper;
import com.banking.ms_customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerEventProducer producer;

    private static final String NOT_FOUND = "Cliente não encontrado";

    @Transactional
    public CustomerResponseDto insert(CustomerCreateDto dto) {
        if (customerRepository.existsByLegalDocument(dto.legalDocument())) {
            throw new CustomerConflictException("Já existe cliente cadastrado com documento: " + dto.legalDocument());
        }
        if (customerRepository.existsByEmailIgnoreCase(dto.email())) {
            throw new CustomerConflictException("Já existe cliente cadastrado com e-mail: " + dto.email());
        }
        var customer = customerMapper.toEntity(dto);
        customerRepository.save(customer);

        producer.publishCustomerCreated(
                new CustomerCreatedEvent(customer.getName(),
                        customer.getLegalDocument(), customer.getEmail(), customer.getStatus()));

        return customerMapper.toResponse(customer);
    }

    @Transactional(readOnly = true)
    public CustomerResponseDto findById(UUID id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(NOT_FOUND));

        return customerMapper.toResponse(customer);
    }

    @Transactional(readOnly = true)
    public Page<CustomerResponseDto> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(customerMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<CustomerResponseDto> search(CustomerSearchDto dto, Pageable pageable) {
        String name = dto.name() != null ? dto.name().toLowerCase() : null;
        String email = dto.email() != null ? dto.email().toLowerCase() : null;

        return customerRepository
                .search(name, dto.legalDocument(), email, dto.dateOfBirth(), dto.status(), pageable)
                .map(customerMapper::toResponse);
    }

    @Transactional
    public CustomerResponseDto updateStatus(UUID id, CustomerStatusUpdateDto dto) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(NOT_FOUND));

        if (dto.status() == Status.ACTIVE) {
            customer.activate();
        }

        producer.publishCustomerStatusUpdated(
                new CustomerStatusUpdatedEvent(customer.getId(), customer.getName(), customer.getEmail(), customer.getStatus())
        );

        return customerMapper.toResponse(customer);
    }

    @Transactional
    public CustomerResponseDto update(UUID id, CustomerUpdateDto dto) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(NOT_FOUND));

        customerMapper.update(dto, customer);
        return customerMapper.toResponse(customer);
    }

    @Transactional
    public void deactivate(UUID id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(NOT_FOUND));

        customer.deactivate();
    }
}
