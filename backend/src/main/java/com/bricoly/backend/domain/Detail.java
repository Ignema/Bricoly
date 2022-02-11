package com.bricoly.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Detail")
public class Detail {
    @Id
    @SequenceGenerator(name = "detail_sequence", sequenceName = "detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_sequence")
    @Column(name = "detail_id", updatable = false)
    private Long detail_id;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Detail detail = (Detail) o;
        return detail_id != null && Objects.equals(detail_id, detail.detail_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}