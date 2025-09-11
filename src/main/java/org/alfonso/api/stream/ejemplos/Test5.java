package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test5
{
    public static void main(String[] args)
    {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Usuario("TON","TIN",20,"12345A"));
        listaDeUsuarios.add(new Usuario("BARTOLO","PERALES",45,"23456B"));
        listaDeUsuarios.add(new Usuario("EUSTAQUIO","BONIATO",59,"34567C"));
        listaDeUsuarios.add(new Usuario("CENUTRIO","MENTECATO",68,"45678D"));
        listaDeUsuarios.add(new Usuario("BARTOLIN","CENUTRITO",20,"56789F"));

        List<Usuario> listaDeUsuariosEditado = listaDeUsuarios.stream().map(it ->edit(it))
                .collect(Collectors.toList());

        Map<Integer ,List<Usuario>> mapaDeUsuariosPorEdadEditado1 = listaDeUsuariosEditado.stream()
                .collect(Collectors.groupingBy(it -> it.getEdad()));


        Map<String, Usuario> mapaDeUsuariosPorDniEditado2 = listaDeUsuarios.stream()
                .map(it -> edit(it))
                .collect(Collectors.toMap( it -> it.getDni(), it -> it));

        System.out.println("PUM");
    }

    public static Usuario edit (Usuario usuario)
    {
        usuario.setNombre(usuario.getNombre().toLowerCase());
        usuario.setApellido(usuario.getApellido() + " Boniato");
        usuario.setApellido(usuario.getApellido().replace("o","a"));
        usuario.setDni(usuario.getDni()+"X");
        return usuario;
    }
}
