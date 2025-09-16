package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class StreamRange
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

        int resultado = IntStream.range(5,20) //20 se EXCLUYE
                .reduce(0,Integer::sum);
        int resultado2 = Arrays.asList(5,6,7,8,9,10,11,12,13,14,15,16,17,18,19).stream()
                .reduce(0,Integer::sum);

        int resultado3 = IntStream.rangeClosed(5,20).sum(); //20 se INCLUYE
        int resultado4 = Arrays.asList(5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream()
                .reduce(0,Integer::sum);

        IntSummaryStatistics stats = IntStream.range(5,20).summaryStatistics();

        System.out.println(resultado);
        System.out.println(resultado2);
        System.out.println(resultado3);
        System.out.println(resultado4);

        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println("total de elementos" + stats.getCount());
    }
}
