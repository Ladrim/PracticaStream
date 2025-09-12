package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.UsuarioA;

import java.util.ArrayList;
import java.util.List;

public class StramFilterSingle2
{
    public static void main(String[] args) throws Exception
    {
        List<String> listaDeNombres = new ArrayList<>();
        listaDeNombres.add("TOMASITO PERALES");
        listaDeNombres.add("MELONCIO LIMONES");
        listaDeNombres.add("EUSTAQUIO MENTECATO");
        listaDeNombres.add("EUSTAQUIO MACUTO");



        UsuarioA usuario = listaDeNombres.stream()
                .map(it ->  {return  new UsuarioA(it.split(" ")[0], it.split(" ")[1],null,null);})


                .filter(it-> it.getId().equals(1))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("EEEEEEEEEEEEEERRRRRRRRROR"));

        System.out.println(usuario);
    }
}
