package com.bricoly.backend.dto;

public class JobDTO extends AbstractDTO<Long> {
    private Long job_id;
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