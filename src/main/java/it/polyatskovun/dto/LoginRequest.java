package it.polyatskovun.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class LoginRequest {
    private UUID id;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
