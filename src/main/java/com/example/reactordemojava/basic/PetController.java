package com.example.reactordemojava.basic;

import com.example.reactordemojava.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pet")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pet> getAll() {
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Pet> getById(@PathVariable Integer id) {
        return service.get(id);
    }

    @PutMapping
    public Pet save(@RequestBody Pet pet) {
        return service.save(pet);
    }

    @GetMapping("/name/{name}")
    public List<Pet> getByName(@PathVariable String name) {
        return service.getByName(name);
    }
}
