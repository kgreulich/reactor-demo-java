package com.example.reactordemojava.basic;

import com.example.reactordemojava.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, Integer> {}
