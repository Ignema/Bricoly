package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Skill")
public class Skill {
    @Id
    @SequenceGenerator(name = "skill_sequence", sequenceName = "skill_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_sequence")
    @Column(name = "skill_id", updatable = false)
    private Long skill_id;

    @Column(name = "skill_name", nullable = false, columnDefinition = "TEXT")
    private String skill_name;

    @ManyToOne
    @JoinTable(name="icon", joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"), inverseJoinColumns = @JoinColumn(name = "icon_id", referencedColumnName = "icon_id"))
    private Icon icon;

    @ManyToOne
    @JoinTable(name="provider", joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"), inverseJoinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "provider_id"))
    private Provider provider;
}