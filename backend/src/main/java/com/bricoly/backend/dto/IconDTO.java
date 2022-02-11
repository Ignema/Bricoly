package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Offer;
import com.bricoly.backend.domain.Skill;

import java.util.List;

public class IconDTO extends AbstractDTO<Long> {
    private Long icon_id;
    private String icon_name;
    private List<Offer> offers;
    private List<Skill> skills;

    public IconDTO() {
    }

    public void setIcon_id(Long icon_id) {
        this.icon_id = icon_id;
    }

    public Long getIcon_id() {
        return this.icon_id;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public String getIcon_name() {
        return this.icon_name;
    }

    public void setOffers(java.util.List<com.bricoly.backend.domain.Offer> offers) {
        this.offers = offers;
    }

    public java.util.List<com.bricoly.backend.domain.Offer> getOffers() {
        return this.offers;
    }

    public void setSkills(java.util.List<com.bricoly.backend.domain.Skill> skills) {
        this.skills = skills;
    }

    public java.util.List<com.bricoly.backend.domain.Skill> getSkills() {
        return this.skills;
    }
}