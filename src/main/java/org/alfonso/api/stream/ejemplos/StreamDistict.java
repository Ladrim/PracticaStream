package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDistict
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("TOMASITO PERALES");

        Stream<UsuarioC> usuarioOptional = listaDeNombres.stream()
                .map(it -> new UsuarioC(it.split(" ")[0], it.split(" ")[1],null,null) )
                .distinct();

        usuarioOptional.forEach(it -> System.out.println(it));
    }
}
