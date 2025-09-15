package org.alfonso.api.stream.ejemplos.models;

public class Factura
{
    private String descripcion;
    private UsuarioFactura usuario;

    public Factura(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {return descripcion;}

    public UsuarioFactura getUsuarioFactura()
    {return usuario;}

    public void setDescripcion(String descripcion)
    {this.descripcion = descripcion;}

    public void setUsuarioFactura(UsuarioFactura usuarioFactura)
    {this.usuario = usuarioFactura;}

    @Override
    public String toString() {
        return descripcion;
    }
}
