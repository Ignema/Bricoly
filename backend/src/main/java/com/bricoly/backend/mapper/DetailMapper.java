package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Detail;
import com.bricoly.backend.dto.DetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DetailMapper extends GenericMapper<Detail, DetailDTO> {
    @Override
    @Mapping(target = "detail_id", ignore = true)
    Detail asEntity(DetailDTO dto);
}