package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Detail;
import com.bricoly.backend.domain.Job;

import java.util.List;

public class OfferDTO extends AbstractDTO<Long> {
    private Long offer_id;
    private String offer_name;
    private String rating;
    private String description;
    private int price;
    private List<Detail> details;
    private List<Job> jobs;

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

    public void setDetails(java.util.List<com.bricoly.backend.domain.Detail> details) {
        this.details = details;
    }

    public java.util.List<com.bricoly.backend.domain.Detail> getDetails() {
        return this.details;
    }

    public void setJobs(java.util.List<com.bricoly.backend.domain.Job> jobs) {
        this.jobs = jobs;
    }

    public java.util.List<com.bricoly.backend.domain.Job> getJobs() {
        return this.jobs;
    }
}