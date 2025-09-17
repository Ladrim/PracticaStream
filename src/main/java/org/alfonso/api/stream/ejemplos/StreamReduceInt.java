package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamReduceInt
{
    public static void main(String[] args) throws Exception
    {
        List<Integer> listaDeInt = new ArrayList<>();
        List<Integer> listaDeInt2 = Arrays.asList(5,10,15,20);
        Integer[] prueba = {1,2,3};

        listaDeInt.add(5);
        listaDeInt.add(10);
        listaDeInt.add(15);
        listaDeInt.add(20);

        Integer resultado = listaDeInt.stream()
                .reduce(0,(a,b) -> a + b);

        System.out.println(resultado);
    }
}
