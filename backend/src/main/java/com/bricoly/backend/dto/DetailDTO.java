package com.bricoly.backend.dto;

public class DetailDTO extends AbstractDTO<Long> {
    private Long detail_id;
    private String name;

    public DetailDTO() {
    }

    public void setDetail_id(Long detail_id) {
        this.detail_id = detail_id;
    }

    public Long getDetail_id() {
        return this.detail_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}