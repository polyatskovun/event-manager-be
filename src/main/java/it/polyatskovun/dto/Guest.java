package it.polyatskovun.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Guest {
    private UUID id;
    private String name;
    private String telephone;
    private String email;
    private int order;
}
