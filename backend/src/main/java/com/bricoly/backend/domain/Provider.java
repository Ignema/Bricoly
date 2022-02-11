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
@Entity(name = "Provider")
public class Provider {
    @Id
    @SequenceGenerator(name = "provider_sequence", sequenceName = "provider_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_sequence")
    @Column(name = "provider_id", updatable = false)
    private Long provider_id;

    @Column(name = "bio", nullable = true, columnDefinition = "TEXT")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinTable(name="days", joinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"), inverseJoinColumns = @JoinColumn(name = "day_id", referencedColumnName = "day_id"))
    private List<Day> days;

    @OneToMany
    @JoinTable(name="skill", joinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"), inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
    private List<Skill> skills;

    @OneToMany
    @JoinTable(name="offer", joinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"), inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"))
    private List<Offer> offers;

    @OneToMany
    @JoinTable(name="job", joinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"), inverseJoinColumns = @JoinColumn(name = "job_id", referencedColumnName = "job_id"))
    private List<Job> jobs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Provider provider = (Provider) o;
        return provider_id != null && Objects.equals(provider_id, provider.provider_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
