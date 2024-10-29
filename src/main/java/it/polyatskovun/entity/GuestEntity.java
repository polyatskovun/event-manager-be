package it.polyatskovun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Guest {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(length = 12)
    private String telephone;

    @Column(length = 32)
    private String email;

    @Column(name = "\"order\"")
    private int order;

    // Getters and Setters
}
