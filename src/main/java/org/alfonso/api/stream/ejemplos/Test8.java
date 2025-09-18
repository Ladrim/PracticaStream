package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Persona;

import java.util.*;
import java.util.stream.Collectors;

public class Test8
{
    public static void main(String[] args)
    {
        List<Persona> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Persona("TON", "TIN", 20, "12345A", 1));
        listaDeUsuarios.add(new Persona("BARTOLO", "PERALES", 45, "23456B", 2));
        listaDeUsuarios.add(new Persona("EUSTAQUIO", "BONIATO", 59, "34567C", 3));

        Map<String, List<Persona>> mapaDePersonasPorApellido = listaDeUsuarios.stream()
                .collect(Collectors.groupingBy(it -> it.getApellido()));

        Map<String, Integer> mapaNumeroDeApellidos = mapaDePersonasPorApellido.entrySet().stream()
                .map(it -> Map.entry(it.getKey(), it.getValue().size()))
                .collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue()));

        Optional<Map.Entry<String, Integer>> masRepetido = mapaNumeroDeApellidos.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer> it) -> it.getValue()).reversed())
                .findFirst();

        Integer numero = masRepetido.map(it -> it.getValue()).orElse(0);
        String apellido = masRepetido.map(it -> it.getKey()).orElse("NINGUNO");

        System.out.println(numero);
        System.out.println(apellido);
    }
}
