package com.bricoly.backend.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class UserDTO extends AbstractDTO<Long> {
    private Long user_id;
    private String first_name;
    private String last_name;
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    private String location;
    private String password;

    public UserDTO() {
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return this.user_id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setDate(java.time.LocalDateTime date) {
        this.date = date;
    }

    public java.time.LocalDateTime getDate() {
        return this.date;
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