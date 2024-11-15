package it.polyatskovun.controller;

import it.polyatskovun.dto.Option;
import it.polyatskovun.service.OptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/options")
public class OptionController {
    private final OptionService service;

    @Autowired
    public OptionController(OptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Option> getAllOptions() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Option getOptionById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Option> createOption(@RequestBody @Valid Option option) {
        Option createdOption = service.save(option);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOption);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOption(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
