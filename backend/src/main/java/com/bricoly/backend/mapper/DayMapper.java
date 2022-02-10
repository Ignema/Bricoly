package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.DayDTO;
import com.bricoly.backend.domain.Day;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DayMapper extends GenericMapper<Day, DayDTO> {
    @Override
    @Mapping(target = "day_id", ignore = false)
    Day asEntity(DayDTO dto);
}