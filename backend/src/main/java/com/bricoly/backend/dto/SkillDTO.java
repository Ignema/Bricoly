package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Icon;
import com.bricoly.backend.domain.Provider;

public class SkillDTO extends AbstractDTO<Long> {
    private Long skill_id;
    private String skill_name;
    private Icon icon;
    private Provider provider;

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

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return this.provider;
    }
}