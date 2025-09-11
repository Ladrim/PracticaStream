package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Alumno;
import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDistictUsuarioSum
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");


        IntStream largoNombres = listaDeNombres.stream()
                .map(it -> new UsuarioA(it.split(" ")[0], it.split(" ")[1],null,null) )
                .distinct()
                .mapToInt(it -> it.getNombre().length()+it.getApellido().length())
                .peek(it -> System.out.println(it));

        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Total " + stats.getSum());
        System.out.println("Average " + stats.getAverage());
        System.out.println("Max " + stats.getMax());
        System.out.println("Min " + stats.getMin());
    }
}
