package com.bricoly.backend.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ProviderDTO extends AbstractDTO<Long> {
    private Long provider_id;
    private String first_name;
    private String last_name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    private String bio;
    private String location;
    private String password;

    public ProviderDTO() {
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
    }

    public Long getProvider_id() {
        return this.provider_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setDate(java.time.LocalDateTime date) {
        this.date = date;
    }

    public java.time.LocalDateTime getDate() {
        return this.date;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return this.bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}