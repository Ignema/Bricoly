package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.DetailDTO;
import com.bricoly.backend.domain.Detail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DetailMapper extends GenericMapper<Detail, DetailDTO> {
    @Override
    @Mapping(target = "detail_id", ignore = false)
    Detail asEntity(DetailDTO dto);
}