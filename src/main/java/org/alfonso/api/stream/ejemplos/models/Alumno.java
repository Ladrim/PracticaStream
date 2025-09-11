package org.alfonso.api.stream.ejemplos.models;

public class Alumno
{
    public String nombre;

    public Alumno(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
