package com.bankingplatform.ms_user.controller;

import com.bankingplatform.ms_user.dto.UserCreateRequestDto;
import com.bankingplatform.ms_user.dto.UserFilterDto;
import com.bankingplatform.ms_user.dto.UserResponseDto;
import com.bankingplatform.ms_user.dto.UserUpdateRequestDto;
import com.bankingplatform.ms_user.service.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e gestão de dados dos clientes")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Criar um novo usuário")
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserCreateRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @Operation(summary = "Paginação do usuários")
    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> findAll( @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @Operation(summary = "Buscar usuário por nome ou cpf")
    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDto>> search(UserFilterDto filter) {
        return ResponseEntity.ok(userService.search(filter));
    }

    @Operation(summary = "Buscar usuário por Id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Atualizar phone e email do usuário")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @RequestBody @Valid UserUpdateRequestDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @Operation(summary = "SoftDelete do usuario")
    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable UUID id) {
        userService.softDelete(id);
    }
}
