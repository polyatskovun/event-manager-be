package it.polyatskovun.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class Guest {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    private String telephone;
    private String email;
    private int order;
}
