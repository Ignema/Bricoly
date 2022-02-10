package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.ProviderDTO;
import com.bricoly.backend.domain.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ProviderMapper extends GenericMapper<Provider, ProviderDTO> {
    @Override
    @Mapping(target = "provider_id", ignore = false)
    Provider asEntity(ProviderDTO dto);
}