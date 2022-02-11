package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Provider;
import com.bricoly.backend.dto.ProviderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProviderMapper extends GenericMapper<Provider, ProviderDTO> {
    @Override
    @Mapping(target = "provider_id", ignore = true)
    Provider asEntity(ProviderDTO dto);
}