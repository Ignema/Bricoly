package com.bricoly.backend.dto;

import com.bricoly.backend.domain.*;

import java.util.List;

public class ProviderDTO extends AbstractDTO<Long> {
    private Long provider_id;
    private String bio;
    private User user;
    private List<Day> days;
    private List<Skill> skills;
    private List<Offer> offers;
    private List<Job> jobs;

    public ProviderDTO() {
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
    }

    public Long getProvider_id() {
        return this.provider_id;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return this.bio;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setDays(java.util.List<com.bricoly.backend.domain.Day> days) {
        this.days = days;
    }

    public java.util.List<com.bricoly.backend.domain.Day> getDays() {
        return this.days;
    }

    public void setSkills(java.util.List<com.bricoly.backend.domain.Skill> skills) {
        this.skills = skills;
    }

    public java.util.List<com.bricoly.backend.domain.Skill> getSkills() {
        return this.skills;
    }

    public void setOffers(java.util.List<com.bricoly.backend.domain.Offer> offers) {
        this.offers = offers;
    }

    public java.util.List<com.bricoly.backend.domain.Offer> getOffers() {
        return this.offers;
    }

    public void setJobs(java.util.List<com.bricoly.backend.domain.Job> jobs) {
        this.jobs = jobs;
    }

    public java.util.List<com.bricoly.backend.domain.Job> getJobs() {
        return this.jobs;
    }
}