package com.example.reactordemojava.reactive;

import com.example.reactordemojava.Pet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactivePetRepository extends ReactiveMongoRepository<Pet, Integer> {}
