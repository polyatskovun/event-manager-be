package it.polyatskovun.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "option")
@Entity
public class OptionEntity {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private String name;

    private Boolean done = false;

    @Column(name = "\"order\"")
    private int order;

    // Getters and Setters
}
