package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter
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
                .filter(it-> it.getNombre().equals("EUSTAQUIO"))
                .peek(it-> System.out.println(it));


        List<UsuarioA> listaDeUsuarios = streamDeUsuarios.collect(Collectors.toList());
        listaDeUsuarios.forEach(it-> System.out.println(it.getApellido()));
    }
}
