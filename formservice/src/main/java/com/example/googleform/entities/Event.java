package com.example.googleform.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Event {
    private Integer id;
    private LocalDate date;
    private String name;
}
