package com.masteraggregator.entity;
import com.masteraggregator.utils.Status_Response;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "order_response",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"order_id", "master_id"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;

    private Double proposedPrice;
    private Instant proposedDate;

    @Enumerated(EnumType.STRING)
    private Status_Response status = Status_Response.PENDING;

    private String comment;
    @Column(updatable = false)
    private Instant createdAt;
    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
}
