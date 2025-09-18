package com.masteraggregator.entity;

import com.masteraggregator.utils.Role;
import com.masteraggregator.utils.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "users") // вместо user, чтобы не конфликтовать с зарезервированным словом
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String avatarUrl;
    private String about;
    private Integer experienceYears;
    private Boolean isVerified = false;

    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Status currentStatus = Status.OFFLINE;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();
}
