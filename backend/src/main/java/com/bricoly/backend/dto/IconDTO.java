package com.bricoly.backend.dto;

public class IconDTO extends AbstractDTO<Long> {
    private Long icon_id;
    private String icon_name;

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
}