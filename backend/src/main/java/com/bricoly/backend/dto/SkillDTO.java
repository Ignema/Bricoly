package com.bricoly.backend.dto;

public class SkillDTO extends AbstractDTO<Long> {
    private Long skill_id;
    private String skill_name;

    public SkillDTO() {
    }

    public void setSkill_id(Long skill_id) {
        this.skill_id = skill_id;
    }

    public Long getSkill_id() {
        return this.skill_id;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_name() {
        return this.skill_name;
    }
}