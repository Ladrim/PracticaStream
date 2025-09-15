package org.alfonso.api.stream.ejemplos;

import java.util.stream.Stream;

public class StreamInfiniteGenerate
{
    public static void main(String[] args)
    {
        Stream.generate(() -> "hola mundo!")
                .limit(20)
                .forEach(it -> System.out.println(it));
    }
}
