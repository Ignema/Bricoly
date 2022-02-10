package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Offer")
public class Offer {
    @Id
    @SequenceGenerator(name = "offer_sequence", sequenceName = "offer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_sequence")
    @Column(name = "offer_id", updatable = false)
    private Long offer_id;

    @Column(name = "offer_name", nullable = false, columnDefinition = "TEXT")
    private String offer_name;

    @ManyToOne
    @JoinTable(name="icon", joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"), inverseJoinColumns = @JoinColumn(name = "icon_id", referencedColumnName = "icon_id"))
    private Icon icon;

    @Column(name = "rating", nullable = false, columnDefinition = "INT")
    private String rating;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "bio", nullable = false, columnDefinition = "INT")
    private int price;

    @ManyToOne
    @JoinTable(name="provider", joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"), inverseJoinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"))
    private Provider provider;

    @ManyToOne
    @JoinTable(name="category", joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Category category;
}