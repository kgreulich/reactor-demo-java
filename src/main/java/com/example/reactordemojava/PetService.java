package com.example.reactordemojava;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Flux<Pet> getAll() {
        return repository.findAll();
    }

    public Mono<Pet> get(Integer id) {
        return repository.findById(id);
    }

    public Mono<Pet> save(Pet pet) {
        return repository.save(pet);
    }

    public Flux<Pet> getByName(String name) {
        return repository.findAll().filter(it -> it.getName().equals(name));
    }

}
