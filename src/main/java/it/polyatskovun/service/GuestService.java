package it.polyatskovun.service;

import it.polyatskovun.dto.Guest;
import it.polyatskovun.entity.GuestEntity;
import it.polyatskovun.exceptions.NotFoundException;
import it.polyatskovun.mappers.GuestMapper;
import it.polyatskovun.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GuestService {
    private final GuestRepository repository;
    private final GuestMapper mapper;


    @Autowired
    public GuestService(GuestRepository repository, GuestMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Guest> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Guest findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    public Guest save(Guest guest) {
        GuestEntity entity = mapper.toEntity(guest);
        GuestEntity saved = repository.save(entity);
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
