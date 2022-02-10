package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Customer;
import com.bricoly.backend.domain.Offer;
import com.bricoly.backend.domain.Provider;

public class JobDTO extends AbstractDTO<Long> {
    private Long job_id;
    private Offer offer;
    private Provider provider;
    private Customer customer;
    private Boolean pending;
    private String rating;

    public JobDTO() {
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public Long getJob_id() {
        return this.job_id;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return this.offer;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Boolean getPending() {
        return this.pending;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return this.rating;
    }
}