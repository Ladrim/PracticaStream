package org.alfonso.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterEmpty
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("");

        long empty  = listaDeNombres.stream()
                .filter(it -> it.isEmpty()).count();
        System.out.println(empty);

        System.out.println(listaDeNombres);
    }
}
