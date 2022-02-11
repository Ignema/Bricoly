package com.bricoly.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Skill")
public class Skill {
    @Id
    @SequenceGenerator(name = "skill_sequence", sequenceName = "skill_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_sequence")
    @Column(name = "skill_id", updatable = false)
    private Long skill_id;

    @Column(name = "skill_name", nullable = false, columnDefinition = "TEXT")
    private String skill_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Skill skill = (Skill) o;
        return skill_id != null && Objects.equals(skill_id, skill.skill_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}