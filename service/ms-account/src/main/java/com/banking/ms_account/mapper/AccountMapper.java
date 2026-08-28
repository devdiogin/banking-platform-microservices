package com.banking.ms_account.mapper;

import com.banking.ms_account.domain.AccountEntity;
import com.banking.ms_account.dto.AccountResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponseDto toResponse(AccountEntity accountEntity);
    List<AccountResponseDto> toResponseList(List<AccountEntity> accountEntities);
}
