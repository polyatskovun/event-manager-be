package it.polyatskovun.mappers;

import it.polyatskovun.dto.Event;
import it.polyatskovun.dto.Guest;
import it.polyatskovun.dto.Option;
import it.polyatskovun.entity.EventEntity;
import it.polyatskovun.entity.GuestEntity;
import it.polyatskovun.entity.OptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapper {
    private final GuestMapper guestMapper;
    private final OptionMapper optionMapper;

    @Autowired
    public EventMapper(GuestMapper guestMapper, OptionMapper optionMapper) {
        this.guestMapper = guestMapper;
        this.optionMapper = optionMapper;
    }

    public Event toDto(EventEntity entity) {
        Event dto = new Event();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDate(entity.getDate());

        List<Guest> guests = entity.getGuests()
                .stream()
                .map(guestMapper::toDto)
                .toList();
        dto.setGuests(guests);

        List<Option> options = entity.getOptions()
                .stream()
                .map(optionMapper::toDto)
                .toList();
        dto.setOptions(options);

        return dto;
    }

    public EventEntity toEntity(Event dto) {
        EventEntity entity = new EventEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());

        if(dto.getGuests() != null){
            List<GuestEntity> guests = dto.getGuests()
                    .stream()
                    .map(guestMapper::toEntity)
                    .toList();
            entity.setGuests(guests);
        }

        if(dto.getOptions() != null){
            List<OptionEntity> options = dto.getOptions()
                    .stream()
                    .map(optionMapper::toEntity)
                    .toList();
            entity.setOptions(options);
        }

        return entity;
    }
}
