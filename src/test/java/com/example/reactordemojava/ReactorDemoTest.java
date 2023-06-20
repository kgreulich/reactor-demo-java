package com.example.reactordemojava;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Disabled
class ReactorDemoTest {

    @Test
    void reactiveTest() {
        Flux.fromIterable(List.of(1, 2, 3, 4, 5))
                .filter(it -> it > 3)
                .subscribe(System.out::println);
    }

    @Test
    void nonReactorTest() {
        Random random = new Random();
        int number = random.nextInt(2);
        try {
            System.out.println(10 / number);
        } catch (ArithmeticException e) {
            System.out.println("I might got $number as random number");
            throw e;
        }
    }

    @Test
    void problematicReactorTest() {
        Mono.just(new Random().nextInt(2))
                .map(it -> 10 / it)
                .doOnError(System.out::println)
                .retry(50)
                .subscribe(System.out::println);
    }

    @Test
    void stillProblematic() {
        int number = new Random().nextInt(2);
        // ↑ DANGER ZONE ↑
        Mono.fromCallable(() -> number)
                .map(it -> 10 / it)
                .doOnError(System.out::println)
                .retry(50)
                .subscribe(System.out::println);
    }

    @Test
    void fixedReactorTest() {
        Mono.fromCallable(() -> new Random().nextInt(2))
                .map(it -> 10 / it)
                .doOnError(System.out::println)
                .retry(50)
                .subscribe(System.out::println);
    }

    @Test
    void blockhoundTest() {
        Mono.delay(Duration.ofSeconds(1))
            .doOnNext(it -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).block();
    }
}
