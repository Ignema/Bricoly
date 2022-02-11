package com.bricoly.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Offer")
public class Offer {
    @Id
    @SequenceGenerator(name = "offer_sequence", sequenceName = "offer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_sequence")
    @Column(name = "offer_id", updatable = false)
    private Long offer_id;

    @Column(name = "offer_name", nullable = false, columnDefinition = "TEXT")
    private String offer_name;

    @Column(name = "rating", nullable = false, columnDefinition = "INT")
    private String rating;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false, columnDefinition = "INT")
    private int price;

    @OneToMany
    @JoinTable(name="detail", joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"), inverseJoinColumns = @JoinColumn(name = "detail_id", referencedColumnName = "detail_id"))
    private List<Detail> details;

    @OneToMany
    @JoinTable(name="job", joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"), inverseJoinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"))
    private List<Job> jobs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Offer offer = (Offer) o;
        return offer_id != null && Objects.equals(offer_id, offer.offer_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}