package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Alumno;
import org.alfonso.api.stream.ejemplos.models.Aula;

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

        Aula aula1 = new Aula(alumnosAula1);
        Aula aula2 = new Aula(alumnosAula2);

        List<Aula>aulas = Arrays.asList(aula1, aula2);

        List<List<Alumno>> listasAlumnos = aulas.stream()
                .map( it -> it.alumnos )
                .toList();


    }
}
