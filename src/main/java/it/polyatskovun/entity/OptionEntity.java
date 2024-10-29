package it.polyatskovun.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Option {
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
