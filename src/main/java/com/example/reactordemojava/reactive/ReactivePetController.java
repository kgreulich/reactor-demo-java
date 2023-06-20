package com.example.reactordemojava.reactive;

import com.example.reactordemojava.Pet;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2/pet")
public class ReactivePetController {

    private final ReactivePetService service;

    public ReactivePetController(ReactivePetService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Pet> getAll() {
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public Mono<Pet> getById(@PathVariable Integer id) {
        return service.get(id);
    }

    @PutMapping
    public Mono<Pet> save(@RequestBody Pet pet) {
        return service.save(pet);
    }

    @GetMapping("/name/{name}")
    public Flux<Pet> getByName(@PathVariable String name) {
        return service.getByName(name);
    }
}
