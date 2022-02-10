package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Icon")
public class Icon {
    @Id
    @SequenceGenerator(name = "icon_sequence", sequenceName = "icon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icon_sequence")
    @Column(name = "icon_id", updatable = false)
    private Long icon_id;

    @Column(name = "icon_name", nullable = false, columnDefinition = "TEXT")
    private String icon_name;
}