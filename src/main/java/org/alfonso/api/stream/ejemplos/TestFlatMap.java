package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Alumno;

import java.util.Arrays;
import java.util.List;

public class TestFlatMap
{
    public static void main(String[] args)
    {
        List<Alumno> alumnosAula1 = Arrays.asList(
                new Alumno("Pepito"),
                new Alumno("Juanito"),
                new Alumno("Pepon")
        );

        List<Alumno>alumnosAula2 = Arrays.asList(
                new Alumno("Fachito"),
                new Alumno("Santito"),
                new Alumno("Cucon"),
                new Alumno("Pepito")
        );


    }
}
