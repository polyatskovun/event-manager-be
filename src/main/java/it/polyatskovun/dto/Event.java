package it.polyatskovun.dto;

import it.polyatskovun.enums.EventType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class Event {

    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private EventType type;
    private LocalDate date;
    private List<Guest> guests;
    private List<Option> options;
}
