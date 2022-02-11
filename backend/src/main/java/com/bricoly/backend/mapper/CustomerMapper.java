package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Customer;
import com.bricoly.backend.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper extends GenericMapper<Customer, CustomerDTO> {
    @Override
    @Mapping(target = "customer_id", ignore = true)
    Customer asEntity(CustomerDTO dto);
}