package it.polyatskovun.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "guest")
@Entity
public class GuestEntity {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(length = 12)
    private String telephone;

    @Column(length = 32)
    private String email;

    @Column(name = "\"order\"")
    private int order;

    // Getters and Setters
}
