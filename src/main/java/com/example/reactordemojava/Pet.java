package com.example.reactordemojava;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Pet {
    @Id
    private Integer id;
    private String name;
    private List<Item> items;
}