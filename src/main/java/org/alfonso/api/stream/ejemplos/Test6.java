package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test6
{
    public static void main(String[] args)
    {
        List<Persona> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(new Persona("TON", "TIN", 20, "12345A", 1));
        listaDeUsuarios.add(new Persona("BARTOLO", "PERALES", 45, "23456B", 2));
        listaDeUsuarios.add(new Persona("EUSTAQUIO", "BONIATO", 59, "34567C", 3));
        listaDeUsuarios.add(new Persona("CENUTRIO", "MENTECATO", 68, "45678D", 4));
    }
}
