package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "Provider")
public class Provider {
    @Id
    @SequenceGenerator(name = "provider_sequence", sequenceName = "provider_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_sequence")
    @Column(name = "provider_id", updatable = false)
    private Long provider_id;

    @Column(name = "bio", nullable = false, columnDefinition = "TEXT")
    private String bio;

    @OneToOne
    @JoinTable(name="user_id")
    private User user;
}
