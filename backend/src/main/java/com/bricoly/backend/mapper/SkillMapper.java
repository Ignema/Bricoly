package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.SkillDTO;
import com.bricoly.backend.domain.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface SkillMapper extends GenericMapper<Skill, SkillDTO> {
    @Override
    @Mapping(target = "skill_id", ignore = false)
    Skill asEntity(SkillDTO dto);
}