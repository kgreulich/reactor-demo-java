package com.example.reactordemojava.reactive;

import com.example.reactordemojava.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ReactivePetServiceTest {

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
    private ReactivePetRepository reactivePetRepository;

    @InjectMocks
    private ReactivePetService reactivePetService;

    @Test
    void findAll() {
        given(reactivePetRepository.findAll()).willReturn(Flux.fromIterable(LIST_OF_PET));

        StepVerifier.create(reactivePetService.getAll())
                .expectNext(FLUFFY)
                .expectNext(HEDWIG)
                .verifyComplete();

        then(reactivePetRepository).should().findAll();
    }

}