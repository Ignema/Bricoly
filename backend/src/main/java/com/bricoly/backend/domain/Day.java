package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Days")
public class Day {
    @Id
    @SequenceGenerator(name = "day_sequence", sequenceName = "day_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "day_sequence")
    @Column(name = "day_id", updatable = false)
    private Long day_id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @ManyToOne
    @JoinTable(name="provider", joinColumns = @JoinColumn(name = "day_id", referencedColumnName = "day_id"), inverseJoinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"))
    private Provider provider;
}