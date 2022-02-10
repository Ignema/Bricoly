package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Job")
public class Job {
    @Id
    @SequenceGenerator(name = "job_sequence", sequenceName = "job_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sequence")
    @Column(name = "job_id", updatable = false)
    private Long job_id;

    @ManyToOne
    @JoinTable(name="offer", joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"), inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"))
    private Offer offer;

    @ManyToOne
    @JoinTable(name="provider", joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"), inverseJoinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"))
    private Provider provider;

    @ManyToOne
    @JoinTable(name="customer", joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"))
    private Customer customer;

    @Column(name = "pending", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean pending;

    @Column(name = "rating", nullable = false, columnDefinition = "INT")
    private String rating;
}