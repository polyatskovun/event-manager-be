package it.polyatskovun.mappers;

import it.polyatskovun.dto.Guest;
import it.polyatskovun.entity.GuestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {

    @Autowired
    public GuestMapper() {}

    public Guest toDto(GuestEntity entity) {
        Guest dto = new Guest();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTelephone(entity.getTelephone());
        dto.setEmail(entity.getEmail());
        dto.setOrder(entity.getOrder());

        return dto;
    }

    public GuestEntity toEntity(Guest dto) {
        GuestEntity entity = new GuestEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        entity.setOrder(dto.getOrder());

        return entity;
    }
}
