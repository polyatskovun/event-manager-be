package it.polyatskovun.controller;

import it.polyatskovun.dto.Event;
import it.polyatskovun.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/public/api/events")
public class PublicEventController {
    private final EventService service;

    @Autowired
    public PublicEventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event) {
        Event createdEvent = service.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
