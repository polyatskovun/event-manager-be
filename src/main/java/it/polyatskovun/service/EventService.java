package it.polyatskovun.service;

import it.polyatskovun.dto.Event;
import it.polyatskovun.entity.EventEntity;
import it.polyatskovun.exceptions.NotFoundException;
import it.polyatskovun.mappers.EventMapper;
import it.polyatskovun.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    private final EventRepository repository;
    private final EventMapper mapper;


    @Autowired
    public EventService(EventRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Event> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Event findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    public Event save(Event event) {
        EventEntity entity = mapper.toEntity(event);
        EventEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public boolean deleteById(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
