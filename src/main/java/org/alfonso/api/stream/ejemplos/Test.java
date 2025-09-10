package org.alfonso.api.stream.ejemplos;

import java.util.Optional;

public class Test
{
    public static void main(String[] args)
    {

        String resultado = formatearNombre(Optional.ofNullable(null),"Cenutrio");
        System.out.println(resultado);
    }


    public static String formatearNombre(Optional<String> nombreOptional, String apellidos)
    {
        nombreOptional
                .map( it -> it.toUpperCase())
                .map( it -> "NOMBRE: " + it );


        String apellidoModificado = apellidos.replace("e","i");


        //String nombre = nombreOptional.orElse("");
        String nombre = nombreOptional.orElseThrow( () -> new RuntimeException("Nombre no puede ser nullo") );

        return nombre + " " + apellidoModificado;
    }
}

