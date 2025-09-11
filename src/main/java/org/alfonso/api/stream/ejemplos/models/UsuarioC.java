package org.alfonso.api.stream.ejemplos.models;

import java.util.Objects;

public class UsuarioC
{
    private String nombre;
    private String apellido;
    final private Integer edad;
    private String dni;
    private Integer id;
    private static int ultimoId;

    public UsuarioC(String nombre, String apellido, Integer edad, String dni)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.id = ++ultimoId;
    }

    public String getNombre() {return nombre;}

    public String getApellido() {return apellido;}

    public Integer getEdad() {return edad;}

    public String getDni() {return dni;}

    public Integer getId() {return id;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public void setDni(String dni) {this.dni = dni;}

    public void setId(Integer id) {this.id = id;}


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioC usuarioC = (UsuarioC) o;
        return Objects.equals(nombre, usuarioC.nombre) && Objects.equals(apellido, usuarioC.apellido);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {return  nombre  + " " + apellido + "\n Edad: " + edad  + "\n DNI " + dni +  "\n id:" + id + "\n";}
}
