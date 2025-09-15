package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamListToStream
{
    public static void main(String[] args)
    {
        List<UsuarioA> lista = new ArrayList<>();
        lista.add(new UsuarioA("Perico","Palotes",15,"12345A"));
        lista.add(new UsuarioA("Manolin","Garcia",25,"23456B"));
        lista.add(new UsuarioA("Vicentico","Cabeson",35,"34567C"));
        lista.add(new UsuarioA("Manolita","Rigrofreda", 72,"56789E"));
        lista.add(new UsuarioA("Vicentica","Perales", 55,"67899F"));


        Stream<String> streamDeUsuarios = lista.stream()
                .map(it -> it.getNombre() + " " + it.getApellido())
                .filter(it -> it.equalsIgnoreCase("Perico Palotes"));

        streamDeUsuarios.forEach(it -> System.out.println(it));
    }
}
