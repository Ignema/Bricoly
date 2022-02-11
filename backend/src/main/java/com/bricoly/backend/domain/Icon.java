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
@Entity(name = "Icon")
public class Icon {
    @Id
    @SequenceGenerator(name = "icon_sequence", sequenceName = "icon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icon_sequence")
    @Column(name = "icon_id", updatable = false)
    private Long icon_id;

    @Column(name = "icon_name", nullable = false, columnDefinition = "TEXT")
    private String icon_name;

    @OneToMany
    @JoinTable(name="offer", joinColumns = @JoinColumn(name = "icon_id", referencedColumnName = "icon_id"), inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"))
    private List<Offer> offers;

    @OneToMany
    @JoinTable(name="skill", joinColumns = @JoinColumn(name = "icon_id", referencedColumnName = "icon_id"), inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
    private List<Skill> skills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Icon icon = (Icon) o;
        return icon_id != null && Objects.equals(icon_id, icon.icon_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}