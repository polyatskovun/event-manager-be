package it.polyatskovun.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "option")
@Entity
public class OptionEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 32)
    private String name;

    private Boolean done;

    @Column(name = "\"order\"")
    private int order;

    // Getters and Setters
}
