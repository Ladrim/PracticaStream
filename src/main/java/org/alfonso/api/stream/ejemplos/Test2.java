package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.*;
import java.util.stream.Collectors;

public class Test2
{
    public static void main(String[] args) {
        List<Integer> listaDeNumeros = new ArrayList<>();
        listaDeNumeros.add(54);
        listaDeNumeros.add(5);
        listaDeNumeros.add(9);
        listaDeNumeros.add(29);
        listaDeNumeros.add(125);

        List<UsuarioA> listaDeUsuarioAS = new ArrayList<>();
        listaDeUsuarioAS.add(new UsuarioA("Ceji","Junto",24,"12345A"));
        listaDeUsuarioAS.add(new UsuarioA("Ben","Ytocamelas",45,"23456B"));
        listaDeUsuarioAS.add(new UsuarioA("Benito","Boniato",59,"34567C"));
        listaDeUsuarioAS.add(new UsuarioA("Camilo","Mentecato",68,"45678D"));
        listaDeUsuarioAS.add(new UsuarioA("Eustaquio","Berbenero",68,"56789E"));
        listaDeUsuarioAS.add(new UsuarioA("Bartolo","Berbenero",70,"67899F"));

        List<Integer> listaOrdenada = listaDeNumeros.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Integer numeroMasGrande = listaDeNumeros.stream()
            .sorted()
            .findFirst().orElseThrow(() -> new RuntimeException("La lista está vacía!!!!"));

        System.out.println(numeroMasGrande);

        List<UsuarioA> listaOrdenadaPorEdad = listaDeUsuarioAS.stream()
            .sorted(Comparator.comparing( it -> it.getEdad()))
            .collect(Collectors.toList());

        List<UsuarioA> listaOrdenadaPorEdadyDni = listaDeUsuarioAS.stream()
            .sorted(Comparator.comparing((UsuarioA it)-> it.getDni()).thenComparing((UsuarioA it) -> it.getDni()))
            .collect(Collectors.toCollection(() -> new ArrayList<>()));

        UsuarioA usuarioAMasEdad = listaDeUsuarioAS.stream()
                .min(Comparator.comparing(UsuarioA::getEdad).reversed().thenComparing(UsuarioA::getNombre)).orElseThrow(() -> new RuntimeException("No se ha encontrado a nadie"));

        List<UsuarioA> listaPim = listaDeUsuarioAS.stream()
            .sorted( Comparator.comparing( it -> it.getEdad() ))
            .toList();

        List<UsuarioA> usuariosEncontradosMayores30 = listaDeUsuarioAS.stream()
                .filter(it -> it.getEdad()>30)
                .collect(Collectors.toList());

        UsuarioA usuarioAMayor30ConDniMenor = listaDeUsuarioAS.stream()
            .filter(it -> it.getEdad() > 20)
            .min(Comparator.comparing(UsuarioA::getDni)).orElseThrow(() -> new RuntimeException("No se ha encontrado a nadie"));

        UsuarioA usuarioAMayor30ConDniMenorTestOrElse = listaDeUsuarioAS.stream()
                .filter(it -> it.getEdad() > 20)
                .min(Comparator.comparing(UsuarioA::getDni)).orElse(new UsuarioA("test","test2",34,"12345k"));

        long cantidadDeUsuarios = listaDeUsuarioAS.stream()
                .count();

        long cantidadDeUsuariosMayores20 = listaDeUsuarioAS.stream()
                .filter(it -> it.getEdad()>20)
                .count();

        String representation = listaOrdenadaPorEdadyDni.stream()
            .map(UsuarioA::toString)
            .collect(Collectors.joining(""));


        System.out.println("REPRESENTATION: " + representation);


        System.out.println(listaOrdenadaPorEdadyDni);
        System.out.println(usuarioAMasEdad);
        System.out.println(usuariosEncontradosMayores30);
        System.out.println(usuarioAMayor30ConDniMenor);
        System.out.println("La cantidad de usuarios es de " + cantidadDeUsuarios);
        System.out.println("Cantidad de usuarios mayores de 20 años es de " + cantidadDeUsuariosMayores20);



    }
}
