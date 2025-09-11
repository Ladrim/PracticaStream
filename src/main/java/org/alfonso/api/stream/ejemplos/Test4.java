package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test4
{
    public static void main(String[] args)
    {
        List<UsuarioA> listaDeUsuarioAS = new ArrayList<>();
        listaDeUsuarioAS.add(creaUsuario("PEPO","Delospalotes",34,"12345A"));
        listaDeUsuarioAS.add(creaUsuario("MANOLIN","Chusquero",55,"23456B"));
        listaDeUsuarioAS.add(creaUsuario("MENGANO","Tibetano",18,"34567C"));
        listaDeUsuarioAS.add(creaUsuario("FULANO","Mongano",56,"45678D"));

        Map<String,List<UsuarioA>> mapaPorDni = listaDeUsuarioAS.stream()
                .map( it -> lowerCaseUsuario(it))
                .collect(Collectors.groupingBy(it -> it.getDni()));


        System.out.println(mapaPorDni);
    }

    // 1st
    public static UsuarioA creaUsuario(String nombre, String apellido, int edad, String dni)
    {
        return new UsuarioA(capitalize(nombre), capitalize(apellido), edad, dni );
    }

    // 2nd
    public static String capitalize(String string)
    {
        String lowerCaseString = string.toLowerCase();
        String firstLetter = lowerCaseString.substring(0, 1).toUpperCase();
        String nextLetters = lowerCaseString.substring(1);

        return firstLetter + nextLetters;
    }

    // 3rd
    public static UsuarioA lowerCaseUsuario(UsuarioA usuarioA)
    {
        usuarioA.setNombre(usuarioA.getNombre().toLowerCase());
        usuarioA.setApellido(usuarioA.getApellido().toLowerCase());
        return usuarioA;
    }
}
