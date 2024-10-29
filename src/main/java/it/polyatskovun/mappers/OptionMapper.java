package it.polyatskovun.mappers;

import it.polyatskovun.dto.Option;
import it.polyatskovun.entity.OptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionMapper {

    @Autowired
    public OptionMapper() {}

    public Option toDto(OptionEntity entity) {
        Option dto = new Option();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDone(entity.getDone());
        dto.setOrder(entity.getOrder());

        return dto;
    }

    public OptionEntity toEntity(Option dto) {
        OptionEntity entity = new OptionEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDone(dto.getDone());
        entity.setOrder(dto.getOrder());

        return entity;
    }
}
