package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Category;
import com.bricoly.backend.domain.Icon;
import com.bricoly.backend.domain.Provider;

public class OfferDTO extends AbstractDTO<Long> {
    private Long offer_id;
    private String offer_name;
    private Icon icon;
    private String rating;
    private String description;
    private int price;
    private Provider provider;
    private Category category;

    public OfferDTO() {
    }

    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

    public Long getOffer_id() {
        return this.offer_id;
    }

    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }

    public String getOffer_name() {
        return this.offer_name;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return this.rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }
}