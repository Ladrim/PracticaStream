package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamFlatMap
{
    public static void main(String[] args)
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");

        Stream<UsuarioA> streamDeUsuarios = listaDeNombres.stream()
                .map(nombre ->  {return  new UsuarioA(nombre.split(" ")[0], nombre.split(" ")[1],null,null);})
                .flatMap(it -> getUsuarioStream(it));

        streamDeUsuarios.forEach(it-> System.out.println());
    }

    private static Stream<UsuarioA> getUsuarioStream(UsuarioA it)
    {
        if (it.getNombre().equalsIgnoreCase("EUSTAQUIO"))
            return Stream.of(it);
        else
            return Stream.empty();
    }
}
