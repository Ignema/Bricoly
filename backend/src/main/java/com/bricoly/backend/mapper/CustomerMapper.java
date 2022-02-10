package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.CustomerDTO;
import com.bricoly.backend.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CustomerMapper extends GenericMapper<Customer, CustomerDTO> {
    @Override
    @Mapping(target = "customer_id", ignore = false)
    Customer asEntity(CustomerDTO dto);
}