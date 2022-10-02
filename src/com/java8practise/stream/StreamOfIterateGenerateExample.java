package com.java8practise.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfIterateGenerateExample {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("First", "Second");
        stringStream.forEach(System.out::println);

        Stream.iterate(1, x -> x * 2)
                .limit(5)
                .forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
