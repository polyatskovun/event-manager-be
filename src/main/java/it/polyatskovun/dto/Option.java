package it.polyatskovun.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class Option {
    private UUID id;
    @NotNull
    private String name;
    private Boolean done;
    private int order;
}
