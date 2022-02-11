package com.bricoly.backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Job")
public class Job {
    @Id
    @SequenceGenerator(name = "job_sequence", sequenceName = "job_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sequence")
    @Column(name = "job_id", updatable = false)
    private Long job_id;

    @Column(name = "pending", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean pending;

    @Column(name = "rating", nullable = false, columnDefinition = "INT")
    private String rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return job_id != null && Objects.equals(job_id, job.job_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}