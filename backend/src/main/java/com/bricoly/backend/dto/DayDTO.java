package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Provider;

public class DayDTO extends AbstractDTO<Long> {
    private Long day_id;
    private String name;
    private Provider provider;

    public DayDTO() {
    }

    public void setDay_id(Long day_id) {
        this.day_id = day_id;
    }

    public Long getDay_id() {
        return this.day_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return this.provider;
    }
}