package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream1
{
    public static void main(String[] args)
    {
        Stream<String> nombres = Stream.of("Perico", "Delospalotes", "Benito", "Camelas");
        nombres.forEach(e -> System.out.println(e));

        String[] array = {"Perico", "Delospalotes", "Benito", "Camelas"};
        Stream<String> nombres2 = Arrays.stream(array);
        nombres2.forEach(e -> System.out.println(e));

        Arrays.stream(array).forEach(a-> System.out.println(a));

        Stream<String> nombres3 = Stream.<String>builder()
            .add("Perico")
            .add("Delospalotes")
            .add("Benito")
            .add("Camelas").build();
        nombres3.forEach(a-> System.out.println(a));

        List<String> test = new ArrayList<>();
        test.add("Manolo");
        test.add("Perico");
        test.add("Camelas");

        test.stream().map(String::toUpperCase);
        Stream<String>stream = test.stream();


        test.forEach(a-> System.out.println(a));
        test.stream().forEach(a-> System.out.println(a));


    }
}
