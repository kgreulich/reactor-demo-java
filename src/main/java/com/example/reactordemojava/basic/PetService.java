package com.example.reactordemojava.basic;

import com.example.reactordemojava.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public List<Pet> getAll() {
        return repository.findAll();
    }

    public Optional<Pet> get(Integer id) {
        return repository.findById(id);
    }

    public Pet save(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> getByName(String name) {
        return repository.findAll().stream().filter(it -> it.getName().equals(name)).toList();
    }

}
