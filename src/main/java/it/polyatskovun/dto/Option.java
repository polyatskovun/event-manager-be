package it.polyatskovun.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Option {
    private UUID id;
    private String name;
    private Boolean done;
    private int order;
}
