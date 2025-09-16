package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap
{
    public static void main(String[] args)
    {
        List<String> nombres = new ArrayList<>();
        nombres.add("Tomasito");
        nombres.add("Meloncio");
        nombres.add("Eustaquio");
        nombres.forEach(nombre-> System.out.println(nombre));

        Stream<String> test = nombres.stream()
                .map(nombre->nombre.toUpperCase())
                .peek(nombre -> System.out.println(nombre))
                .map(nombre -> "NOMBRE: " + nombre);

        test.forEach(nombre-> System.out.println(nombre));

        List<String> toUpperCaseList = nombres.stream().map(String::toUpperCase).collect(Collectors.toList());
        toUpperCaseList.forEach(System.out::println);


        Stream<String> nombres1 = Stream.of("Perico", "Delospalotes", "Benito", "Camelas").peek(a-> System.out.println(a)).map(nombre->{return nombre.replace("e","i");});
        Stream<String> nombres2 = Stream.of("Perico", "Delospalotes", "Benito", "Camelas").map(nombre->{return nombre.toUpperCase();});

        nombres1.forEach(e -> System.out.println(e));
        nombres2.forEach(e -> System.out.println(e));

    }
}
