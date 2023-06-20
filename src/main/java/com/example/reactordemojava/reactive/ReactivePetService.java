package com.example.reactordemojava.reactive;

import com.example.reactordemojava.Pet;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactivePetService {

    private final ReactivePetRepository repository;

    public ReactivePetService(ReactivePetRepository repository) {
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
