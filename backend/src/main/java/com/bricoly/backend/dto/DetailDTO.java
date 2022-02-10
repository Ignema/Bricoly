package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Offer;

public class DetailDTO extends AbstractDTO<Long> {
    private Long detail_id;
    private String name;
    private Offer offer;

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

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return this.offer;
    }
}