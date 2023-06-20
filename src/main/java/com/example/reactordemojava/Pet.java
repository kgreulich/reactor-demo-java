package com.example.reactordemojava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Pet {
    @Id
    private Integer id;
    private String name;
    private List<Item> items;
}