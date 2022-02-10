package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Detail")
public class Detail {
    @Id
    @SequenceGenerator(name = "detail_sequence", sequenceName = "detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_sequence")
    @Column(name = "detail_id", updatable = false)
    private Long detail_id;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String name;

    @ManyToOne
    @JoinTable(name="offer", joinColumns = @JoinColumn(name = "detail_id", referencedColumnName = "detail_id"), inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "offer_id"))
    private Offer offer;
}