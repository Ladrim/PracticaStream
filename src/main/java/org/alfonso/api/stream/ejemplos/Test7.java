package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Persona;

import java.util.*;
import java.util.stream.Collectors;

public class Test7
{
    public static void main(String[] args)
    {
        List<Persona> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Persona("TON","TIN",20,"12345A",1));
        listaDeUsuarios.add(new Persona("BARTOLO","PERALES",45,"23456B",2));
        listaDeUsuarios.add(new Persona("EUSTAQUIO","BONIATO",59,"34567C",3));
        listaDeUsuarios.add(new Persona("CENUTRIO","MENTECATO",68,"45678D",4));
        listaDeUsuarios.add(new Persona("BARTOLIN","CENUTRITO",20,"56789F",5));
        listaDeUsuarios.add(new Persona("ENANIN","CENUTRITO",20,"67899J",6));

        Map<String,List<Persona>> mapaDePersonasPorApellido = listaDeUsuarios.stream()
                .collect(Collectors.groupingBy(it -> it.getApellido()));

        Map<String, Integer> mapaNumeroDeApellidos = mapaDePersonasPorApellido.entrySet().stream()
                .map(it -> Map.entry(it.getKey(),it.getValue().size()))
                .collect(Collectors.toMap(it -> it.getKey(), it-> it.getValue()));

        Optional<Map.Entry<String, Integer>> masRepetido = mapaNumeroDeApellidos.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer> it) -> it.getValue()).reversed())
                .findFirst();

        Integer numero = masRepetido.map( it -> it.getValue()).orElse(0);
        String apellido = masRepetido.map( it -> it.getKey() ).orElse("NINGUNO");

        System.out.println(numero);
        System.out.println(apellido);


        Optional<Map.Entry<String, Integer>>optional = listaDeUsuarios.stream()
                .collect(Collectors.groupingBy( it -> it.getApellido())).entrySet().stream()
                .collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue().size())).entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer> it) -> it.getValue()).reversed())
                .findFirst();

        Integer numero2 = optional.map( it -> it.getValue()).orElse(0);
        String apellido2 = optional.map( it -> it.getKey() ).orElse("NINGUNO");

        listaDeUsuarios.stream()
                .collect(Collectors.groupingBy(Persona::getApellido, Collectors.counting())).entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .findFirst();
    }

    public void version2()
    {
        List<Persona> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Persona("TON","TIN",20,"12345A",1));
        listaDeUsuarios.add(new Persona("BARTOLO","PERALES",45,"23456B",2));
        listaDeUsuarios.add(new Persona("EUSTAQUIO","BONIATO",59,"34567C",3));
        listaDeUsuarios.add(new Persona("CENUTRIO","MENTECATO",68,"45678D",4));
        listaDeUsuarios.add(new Persona("BARTOLIN","CENUTRITO",20,"56789F",5));
        listaDeUsuarios.add(new Persona("ENANIN","CENUTRITO",20,"67899J",6));

        Map<Integer, Persona> mapaDePersonasPorCodigo = listaDeUsuarios.stream()
                .collect(Collectors.toMap(it -> it.getCodigo(),it-> it));


        Map<String,List<Persona>> mapaDePersonasPorApellido = listaDeUsuarios.stream()
                .collect(Collectors.groupingBy(it -> it.getApellido()));

        Map<String, Integer> mapaNumeroDeApellidos = mapaDePersonasPorApellido.entrySet().stream()
                .map(it -> Map.entry(it.getKey(),it.getValue().size()))
                .collect(Collectors.toMap(it -> it.getKey(), it-> it.getValue()));

        Optional<Integer> numeroDeRepeticiones = mapaNumeroDeApellidos.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer>it) -> it.getValue()).reversed())
                .findFirst() // OPTIONAL ENTRY(APELLIDO -> key, REPETICIONS -> value)
                .map(it -> it.getValue());

        Optional<String> nombreMasRepetido = mapaNumeroDeApellidos.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Integer>it) -> it.getValue()).reversed())
                .findFirst()
                .map(it -> it.getKey());
    }
}
