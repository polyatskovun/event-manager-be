package it.polyatskovun.service;

import it.polyatskovun.dto.Option;
import it.polyatskovun.entity.OptionEntity;
import it.polyatskovun.exceptions.NotFoundException;
import it.polyatskovun.mappers.OptionMapper;
import it.polyatskovun.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OptionService {
    private final OptionRepository repository;
    private final OptionMapper mapper;

    @Autowired
    public OptionService(OptionRepository repository, OptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Option> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public Option findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    public Option save(Option option) {
        OptionEntity entity = mapper.toEntity(option);
        OptionEntity saved = repository.save(entity);
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
