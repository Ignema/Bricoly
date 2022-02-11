package com.bricoly.backend.dto;

import com.bricoly.backend.domain.Job;
import com.bricoly.backend.domain.User;

import java.util.List;

public class CustomerDTO extends AbstractDTO<Long> {
    private Long customer_id;
    private List<Job> jobs;
    private User user;

    public CustomerDTO() {
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getCustomer_id() {
        return this.customer_id;
    }

    public void setJobs(java.util.List<com.bricoly.backend.domain.Job> jobs) {
        this.jobs = jobs;
    }

    public java.util.List<com.bricoly.backend.domain.Job> getJobs() {
        return this.jobs;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}