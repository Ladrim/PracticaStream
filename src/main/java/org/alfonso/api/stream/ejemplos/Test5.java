package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test5
{
    public static void main(String[] args)
    {
        List<UsuarioA> listaDeUsuarioAS = new ArrayList<>();
        listaDeUsuarioAS.add(new UsuarioA("TON","TIN",20,"12345A"));
        listaDeUsuarioAS.add(new UsuarioA("BARTOLO","PERALES",45,"23456B"));
        listaDeUsuarioAS.add(new UsuarioA("EUSTAQUIO","BONIATO",59,"34567C"));
        listaDeUsuarioAS.add(new UsuarioA("CENUTRIO","MENTECATO",68,"45678D"));
        listaDeUsuarioAS.add(new UsuarioA("BARTOLIN","CENUTRITO",20,"56789F"));

        List<UsuarioA> listaDeUsuariosEditado = listaDeUsuarioAS.stream().map(it ->edit(it))
                .collect(Collectors.toList());

        Map<Integer ,List<UsuarioA>> mapaDeUsuariosPorEdadEditado1 = listaDeUsuariosEditado.stream()
                .collect(Collectors.groupingBy(it -> it.getEdad()));


        Map<String, UsuarioA> mapaDeUsuariosPorDniEditado2 = listaDeUsuarioAS.stream()
                .map(it -> edit(it))
                .collect(Collectors.toMap( it -> it.getDni(), it -> it));

        System.out.println("PUM");
    }

    public static UsuarioA edit (UsuarioA usuarioA)
    {
        usuarioA.setNombre(usuarioA.getNombre().toLowerCase());
        usuarioA.setApellido(usuarioA.getApellido() + " Boniato");
        usuarioA.setApellido(usuarioA.getApellido().replace("o","a"));
        usuarioA.setDni(usuarioA.getDni()+"X");
        return usuarioA;
    }
}
