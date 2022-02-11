package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Icon;
import com.bricoly.backend.dto.IconDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IconMapper extends GenericMapper<Icon, IconDTO> {
    @Override
    @Mapping(target = "icon_id", ignore = true)
    Icon asEntity(IconDTO dto);
}