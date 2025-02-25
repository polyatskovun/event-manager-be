package it.polyatskovun.mappers;

import it.polyatskovun.dto.LoginRequest;
import it.polyatskovun.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    public UserMapper() {}

    public LoginRequest toDto(UserEntity entity) {
        LoginRequest dto = new LoginRequest();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public UserEntity toEntity(LoginRequest dto) {
        UserEntity entity = new UserEntity();

        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
