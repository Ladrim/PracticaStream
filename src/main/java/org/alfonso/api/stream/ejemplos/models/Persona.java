package org.alfonso.api.stream.ejemplos.models;

public class Persona
{
    private String nombre;
    private String apellido;
    final private Integer edad;
    private String dni;
    private Integer id;
    private static int ultimoId;
    private int codigo;

    public Persona(String nombre, String apellido, Integer edad, String dni, int codigo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.id = ++ultimoId;
        this.codigo = codigo;
    }

    public String getNombre() {return nombre;}

    public String getApellido() {return apellido;}

    public Integer getEdad() {return edad;}

    public String getDni() {return dni;}

    public Integer getId() {return id;}

    public int getCodigo() {return codigo;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public void setDni(String dni) {this.dni = dni;}

    public void setId(Integer id) {this.id = id;}

    public void setCodigo(int codigo) {this.codigo = codigo;}

    @Override
    public String toString() {return  nombre  + " " + apellido + "\n Edad: " + edad  + "\n DNI " + dni + "\n Codigo " + codigo + "\n id:" + id + "\n";}
}
