package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Day;
import com.bricoly.backend.dto.DayDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DayMapper extends GenericMapper<Day, DayDTO> {
    @Override
    @Mapping(target = "day_id", ignore = true)
    Day asEntity(DayDTO dto);
}