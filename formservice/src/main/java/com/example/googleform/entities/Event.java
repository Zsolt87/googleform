package com.example.googleform.entities;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class Event {
    private UUID id;
    private Instant instant;
    private String name;
}
