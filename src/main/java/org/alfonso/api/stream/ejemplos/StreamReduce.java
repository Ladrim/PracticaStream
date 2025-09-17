package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class StreamReduce
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("JUANITO PERALES");
        listaDeNombres.add("ALFONSO MENTECATO");

        String resultado = listaDeNombres.stream()
                .distinct()
                .reduce("PRUEBA: ",(a,b) -> a + ", " + b);

        System.out.println(resultado);
    }
}
