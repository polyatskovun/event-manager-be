package it.polyatskovun.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class Event {

    private UUID id;
    private String name;
    private LocalDate date;
    private List<Guest> guests;
    private List<Option> options;
}
