package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Category")
public class Category {
    @Id
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @Column(name = "category_id", updatable = false)
    private Long category_id;

    @Column(name = "category_name", nullable = false, columnDefinition = "TEXT")
    private String category_name;
}