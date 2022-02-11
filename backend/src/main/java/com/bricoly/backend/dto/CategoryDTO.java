package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Offer;

import java.util.List;

public class CategoryDTO extends AbstractDTO<Long> {
    private Long category_id;
    private String category_name;
    private List<Offer> offers;

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

    public void setOffers(java.util.List<com.bricoly.backend.domain.Offer> offers) {
        this.offers = offers;
    }

    public java.util.List<com.bricoly.backend.domain.Offer> getOffers() {
        return this.offers;
    }
}