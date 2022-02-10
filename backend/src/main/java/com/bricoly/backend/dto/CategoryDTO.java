package com.bricoly.backend.dto;

public class CategoryDTO extends AbstractDTO<Long> {
    private Long category_id;
    private String category_name;

    public CategoryDTO() {
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getCategory_id() {
        return this.category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return this.category_name;
    }
}