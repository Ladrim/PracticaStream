package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;

public class StreamParallel
{
    public static void main(String[] args)
    {
        List<UsuarioA> lista = new ArrayList<>();
        lista.add(new UsuarioA("Manolin","Garcia",25,"23456B"));
        lista.add(new UsuarioA("Vicentico","Cabeson",35,"34567C"));
        lista.add(new UsuarioA("Eustaquio","Berbenero",55,"45678D"));
        lista.add(new UsuarioA("Manolita","Rigrofreda", 72,"56789E"));
        lista.add(new UsuarioA("Vicentica","Perales", 55,"67899F"));
        lista.add(new UsuarioA("Perico","Palotes",15,"12345A"));


        long t1 = System.currentTimeMillis();

        String resultado = lista.stream().parallel()
                .map( it -> toNombreYApellido(it))
                .filter( it -> equalsPericoPalotes(it))
                .findAny().orElse(" ");

        /*List<String>pim = lista.stream()
                .map(EjemploStreamParallel::toNombreYApellido)
                .toList();
        */
        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 - t1));

        System.out.println("Resultado: " + resultado);
    }

    private static String toNombreYApellido(UsuarioA usuario)
    {
        try
        {
            System.out.println("map");
            Thread.sleep(1000);
            return usuario.getNombre() + " " + usuario.getApellido();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static boolean equalsPericoPalotes(String it)
    {
        System.out.println("equals");
        return it.equalsIgnoreCase("Perico Palotes");
    }
}
