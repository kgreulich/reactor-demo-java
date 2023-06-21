package com.example.reactordemojava;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private int age;

    public boolean isAdult() {
        return age >= 18;
    }
}
