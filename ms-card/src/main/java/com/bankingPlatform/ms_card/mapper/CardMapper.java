package com.bankingPlatform.ms_card.mapper;

import com.bankingPlatform.ms_card.dto.CardCreateRequestDto;
import com.bankingPlatform.ms_card.dto.CardResponseDto;
import com.bankingPlatform.ms_card.dto.CardUpdateDto;
import com.bankingPlatform.ms_card.model.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CardMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountId", ignore = true)
    @Mapping(target = "cardNumber", ignore = true)
    @Mapping(target = "cvv", ignore = true)
    @Mapping(target = "expirationDate", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    CardEntity toEntity(CardCreateRequestDto request);

    CardResponseDto toResponse(CardEntity entity);

    List<CardResponseDto> toResponseList(List<CardEntity> entityList);

    void update(CardUpdateDto dto, @MappingTarget CardEntity entity);
}
