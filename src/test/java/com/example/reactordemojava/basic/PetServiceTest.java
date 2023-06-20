package com.example.reactordemojava.basic;

import com.example.reactordemojava.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit. jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    private static final Pet FLUFFY = Pet.builder()
            .id(1)
            .name("Fluffy")
            .build();

    private static final Pet HEDWIG = Pet.builder()
            .id(2)
            .name("Hedwig")
            .build();

    private static final List<Pet> LIST_OF_PET = List.of(FLUFFY, HEDWIG);

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService petService;

    @Test
    void getAll() {
        given(petRepository.findAll()).willReturn(LIST_OF_PET);

        assertEquals(LIST_OF_PET, petService.getAll());
        then(petRepository).should().findAll();
    }

    @Test
    void getById() {
        given(petRepository.findById(1)).willReturn(Optional.of(FLUFFY));

        assertEquals(Optional.of(FLUFFY), petService.get(1));
        then(petRepository).should().findById(1);
    }

    @Test
    void save() {
        given(petRepository.save(FLUFFY)).willReturn(FLUFFY);

        assertEquals(FLUFFY, petService.save(FLUFFY));
        then(petRepository).should().save(FLUFFY);
    }

    @Test
    void getByName() {
        given(petRepository.findAll()).willReturn(LIST_OF_PET);

        assertEquals(List.of(HEDWIG), petService.getByName(HEDWIG.getName()));
        then(petRepository).should().findAll();
    }

}