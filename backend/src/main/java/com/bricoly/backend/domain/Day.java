package com.bricoly.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Days")
public class Day {
    @Id
    @SequenceGenerator(name = "day_sequence", sequenceName = "day_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "day_sequence")
    @Column(name = "day_id", updatable = false)
    private Long day_id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Day day = (Day) o;
        return day_id != null && Objects.equals(day_id, day.day_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}