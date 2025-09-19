package com.masteraggregator.entity;

import com.masteraggregator.utils.Status_Order;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status_Order status_order = Status_Order.CREATED;

    private Double finalPrice;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    private String address;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "assigned_master_id")
    private User assignedMaster;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Instant createdAt = Instant.now();
    private Instant plannedDate;
    private Instant completedAt;

}

