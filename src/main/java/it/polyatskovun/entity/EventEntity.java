package it.polyatskovun.entity;

import it.polyatskovun.enums.EventType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "event")
@Entity()
public class EventEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EventType type;

    private LocalDate date;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "event_guest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<GuestEntity> guests;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "event_option",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<OptionEntity> options;

    // Getters and Setters
}
