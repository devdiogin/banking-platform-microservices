package com.banking.ms_customer.mapper;

import com.banking.ms_customer.dto.CustomerCreateDto;
import com.banking.ms_customer.dto.CustomerResponseDto;
import com.banking.ms_customer.dto.CustomerUpdateDto;
import com.banking.ms_customer.model.CustomerEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CustomerEntity toEntity(CustomerCreateDto dto);

    CustomerResponseDto toResponse(CustomerEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(CustomerUpdateDto dto, @MappingTarget CustomerEntity entity);

    List<CustomerResponseDto> toResponseList(List<CustomerEntity> entityList);
}
