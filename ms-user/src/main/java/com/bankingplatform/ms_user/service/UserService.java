package com.bankingplatform.ms_user.service;

import com.bankingplatform.ms_user.dto.UserCreateRequestDto;
import com.bankingplatform.ms_user.dto.UserFilterDto;
import com.bankingplatform.ms_user.dto.UserResponseDto;
import com.bankingplatform.ms_user.dto.UserUpdateRequestDto;
import com.bankingplatform.ms_user.exception.DuplicateCpfException;
import com.bankingplatform.ms_user.exception.DuplicateEmailException;
import com.bankingplatform.ms_user.exception.UserNotFoundException;
import com.bankingplatform.ms_user.mapper.UserMapper;
import com.bankingplatform.ms_user.model.StatusUser;
import com.bankingplatform.ms_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    private static final String USER_NOT_FOUND = "Usuário não encontrado.";

    @Transactional
    public UserResponseDto createUser(UserCreateRequestDto dto) {
        if (userRepository.existsByCpf(dto.cpf())) {
            throw new DuplicateCpfException("CPF já cadastrado.");
        }

        if (userRepository.existsByEmail(dto.email())) {
            throw new DuplicateEmailException("E-mail já cadastrado.");
        }

        var user = userMapper.toEntity(dto);
        user.setStatus(StatusUser.PENDING_KYC);
        user.setCreatedAt(Instant.now(Clock.systemUTC()));

        return userMapper.toResponse(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> search(UserFilterDto filter) {

        if (filter.name() != null && !filter.name().isBlank()) {
            return userMapper.toResponseList(
                    userRepository.findByFullNameContainingIgnoreCase(filter.name()));
        }

        if (filter.cpf() != null && !filter.cpf().isBlank()) {
            return userRepository.findByCpf(filter.cpf())
                    .map(List::of)
                    .map(userMapper::toResponseList)
                    .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        }

        throw new IllegalArgumentException("Informe ao menos um parâmetro para busca");
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(UUID id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        return userMapper.toResponse(user);
    }

    @Transactional
    public UserResponseDto updateUser(UUID id, UserUpdateRequestDto dto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        userMapper.updateEntity(dto, user);

        return userMapper.toResponse(user);
    }

    @Transactional
    public void softDelete(UUID id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        user.setStatus(StatusUser.DELETED);
    }
}
