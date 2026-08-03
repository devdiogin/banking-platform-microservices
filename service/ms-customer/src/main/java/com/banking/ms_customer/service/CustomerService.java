package com.banking.ms_customer.service;

import com.banking.ms_customer.dto.CustomerCreateDto;
import com.banking.ms_customer.dto.CustomerResponseDto;
import com.banking.ms_customer.dto.CustomerSearchDto;
import com.banking.ms_customer.exception.CustomerConflitException;
import com.banking.ms_customer.exception.CustomerNotFoundException;
import com.banking.ms_customer.mapper.CustomerMapper;
import com.banking.ms_customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    private static final String NOT_FOUND = "Cliente não encontrado";

    @Transactional
    public CustomerResponseDto insert(CustomerCreateDto dto) {
        if (customerRepository.existsByLegalDocument(dto.legalDocument())) {
            throw new CustomerConflitException("Já existe cliente cadastrado com documento: " + dto.legalDocument());
        }
        if (customerRepository.existsByEmail(dto.email())) {
            throw new CustomerConflitException("Já existe cliente cadastrado com e-mail: " + dto.email());
        }
        var customer = customerMapper.toEntity(dto);
        customerRepository.save(customer);

        return customerMapper.toResponse(customer);
    }

    @Transactional(readOnly = true)
    public Page<CustomerResponseDto> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(customerMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public CustomerResponseDto findById(UUID id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(NOT_FOUND));

        return customerMapper.toResponse(customer);
    }

    @Transactional(readOnly = true)
    public List<CustomerResponseDto> search(CustomerSearchDto search) {
    }
}
