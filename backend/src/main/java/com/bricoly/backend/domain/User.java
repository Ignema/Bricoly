package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "Users")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id", updatable = false)
    private Long user_id;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String first_name;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String last_name;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "birthday", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @Column(name = "location", nullable = false, columnDefinition = "TEXT")
    private String location;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;
}
