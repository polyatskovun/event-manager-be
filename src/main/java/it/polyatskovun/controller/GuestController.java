package it.polyatskovun.controller;

import it.polyatskovun.dto.Guest;
import it.polyatskovun.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    private final GuestService service;

    @Autowired
    public GuestController(GuestService service) {
        this.service = service;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest createdGuest = service.save(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGuest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGuest(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
