package com.bricoly.backend.domain;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "Customer")
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(name = "customer_id", updatable = false)
    private Long customer_id;

    @OneToOne
    @JoinTable(name="user_id")
    private User user;
}
