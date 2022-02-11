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
@Entity(name = "Category")
public class Category {
    @Id
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @Column(name = "category_id", updatable = false)
    private Long category_id;

    @Column(name = "category_name", nullable = false, columnDefinition = "TEXT")
    private String category_name;

    @OneToMany
    @JoinTable(name="offer", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"), inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"))
    @ToString.Exclude
    private List<Offer> offers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return category_id != null && Objects.equals(category_id, category.category_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}