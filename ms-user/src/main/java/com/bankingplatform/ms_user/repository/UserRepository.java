package com.bankingplatform.ms_user.repository;

import com.bankingplatform.ms_user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    List<UserEntity> findByFullNameContainingIgnoreCase(String name);
    Optional<UserEntity> findByCpf(String cpf);

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
