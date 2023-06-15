package com.example.reactordemojava;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Item {
    private String description;
    private Float value;
    private LocalDate date;
}
