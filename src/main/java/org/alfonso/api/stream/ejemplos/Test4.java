package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test4
{
    public static void main(String[] args)
    {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(creaUsuario("PEPO","Delospalotes",34,"12345A"));
        listaDeUsuarios.add(creaUsuario("MANOLIN","Chusquero",55,"23456B"));
        listaDeUsuarios.add(creaUsuario("MENGANO","Tibetano",18,"34567C"));
        listaDeUsuarios.add(creaUsuario("FULANO","Mongano",56,"45678D"));

        Map<String,List<Usuario>> mapaPorDni = listaDeUsuarios.stream()
                .map( it -> lowerCaseUsuario(it))
                .collect(Collectors.groupingBy(it -> it.getDni()));


        System.out.println(mapaPorDni);
    }

    // 1st
    public static Usuario creaUsuario(String nombre, String apellido, int edad, String dni)
    {
        return new Usuario(capitalize(nombre), capitalize(apellido), edad, dni );
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
    public static Usuario lowerCaseUsuario(Usuario usuario)
    {
        usuario.setNombre(usuario.getNombre().toLowerCase());
        usuario.setApellido(usuario.getApellido().toLowerCase());
        return usuario;
    }
}
