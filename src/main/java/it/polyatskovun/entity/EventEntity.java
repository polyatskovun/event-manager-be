package it.polyatskovun.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 32)
    private String name;

    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "event_guests",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests;

    @ManyToMany
    @JoinTable(
            name = "event_options",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<Option> options;


    // Getters and Setters
}
