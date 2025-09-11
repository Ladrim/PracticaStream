package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3
{
    public static void main(String[] args)
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("JUANITO PERALES");
        listaDeNombres.add("ALFONSO MENTECATO");

        List<UsuarioA> listaUsuarioAS = listaDeNombres.stream()
                .map(nombre -> crearUsuario(nombre))
                .toList();



        Map<String, List<UsuarioA>> mapaPorApellido =  listaUsuarioAS.stream()
                .collect(Collectors.groupingBy( (it) -> it.getApellido()));



        String optional = mapaPorApellido.entrySet().stream()  // ENTRY<String, List>
                .map( it -> Map.entry(it.getKey(), it.getValue().size() )) // ENTRY<String, Integer>
                .sorted(Comparator.comparing( (Map.Entry<String, Integer> it) -> it.getValue() ).reversed())
                .findFirst()
                .map( it -> it.getKey() )
                .orElse("");

        System.out.println(optional);
    }

    private static UsuarioA crearUsuario(String nombreYApellidos)
    {
        String[]valores = nombreYApellidos.split(" ");
        String nombre = valores[0];
        String apellidos = valores[1];

        return new UsuarioA(nombre, apellidos, null, null);
    }
}
