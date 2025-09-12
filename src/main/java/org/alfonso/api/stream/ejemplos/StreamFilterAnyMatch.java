package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterAnyMatch
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");

        boolean existe = listaDeNombres.stream()
                .map(it ->  crearUsuario(it))
                .anyMatch(it -> it.getId().equals(2));

        System.out.println(existe);
    }

    private static UsuarioA crearUsuario(String it)
    {
        String[] valor = it.split("");
        String nombre = valor[0];
        String apellido = valor[1];
        return new UsuarioA(nombre, apellido, null, null);
    }
}

