package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamFilterSingle
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");

        UsuarioA manolin = new UsuarioA("MANOLIN","RIGOBERTO",25,"12345K");

        Optional<UsuarioA> usuarioOptional = listaDeNombres.stream()
                .map(it -> new UsuarioA(it.split(" ")[0], it.split(" ")[1],null,null) )
                .filter(it -> it.getNombre().equals("EUSTAQUIOX"))
                .findFirst();

        if(usuarioOptional.isPresent())
        {
            System.out.println(usuarioOptional.get().getNombre());
        }
        else System.out.println("No se encontró");


        UsuarioA usuario = usuarioOptional.get();
        UsuarioA usuario2 = usuarioOptional.orElse(new UsuarioA("Pepe","Canelas",67,"12345K"));
        UsuarioA usuario3 = usuarioOptional.orElseThrow( () -> new RuntimeException("") );

        System.out.println(usuario);


        if(!usuarioOptional.isEmpty()) System.out.println(usuarioOptional.orElseThrow());

        System.out.println(usuarioOptional.orElseThrow(() -> new RuntimeException("Error")));
    }
}
