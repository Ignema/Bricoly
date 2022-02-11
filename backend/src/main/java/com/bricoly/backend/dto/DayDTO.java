package com.bricoly.backend.dto;

public class DayDTO extends AbstractDTO<Long> {
    private Long day_id;
    private String name;

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
}