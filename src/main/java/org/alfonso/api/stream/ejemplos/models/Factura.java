package org.alfonso.api.stream.ejemplos.models;

public class Factura
{
    private String descripcion;
    private UsuarioA usuario;

    public Factura(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {return descripcion;}

    public UsuarioA getUsuarioFactura()
    {return usuario;}

    public void setDescripcion(String descripcion)
    {this.descripcion = descripcion;}

    public void setUsuarioFactura(UsuarioA usuarioFactura)
    {this.usuario = usuarioFactura;}

    @Override
    public String toString() {
        return descripcion;
    }
}
