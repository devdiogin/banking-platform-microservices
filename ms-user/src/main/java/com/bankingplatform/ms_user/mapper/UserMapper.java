package com.bankingplatform.ms_user.mapper;

import com.bankingplatform.ms_user.dto.UserCreateRequestDto;
import com.bankingplatform.ms_user.dto.UserResponseDto;
import com.bankingplatform.ms_user.dto.UserUpdateRequestDto;
import com.bankingplatform.ms_user.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserEntity toEntity(UserCreateRequestDto request);

    UserResponseDto toResponse(UserEntity user);

    List<UserResponseDto> toResponseList(List<UserEntity> userList);

    void updateEntity(UserUpdateRequestDto dto, @MappingTarget UserEntity user);
}
