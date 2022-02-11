package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Skill;
import com.bricoly.backend.dto.SkillDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper extends GenericMapper<Skill, SkillDTO> {
    @Override
    @Mapping(target = "skill_id", ignore = true)
    Skill asEntity(SkillDTO dto);
}