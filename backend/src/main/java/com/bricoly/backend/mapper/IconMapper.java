package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.IconDTO;
import com.bricoly.backend.domain.Icon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface IconMapper extends GenericMapper<Icon, IconDTO> {
    @Override
    @Mapping(target = "icon_id", ignore = false)
    Icon asEntity(IconDTO dto);
}