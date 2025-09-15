package org.alfonso.api.stream.ejemplos;

import org.alfonso.api.stream.ejemplos.models.Factura;
import org.alfonso.api.stream.ejemplos.models.UsuarioA;
import org.alfonso.api.stream.ejemplos.models.UsuarioFactura;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMapFacturas
{
    public static void main(String[] args) {
        UsuarioFactura u1 = new UsuarioFactura("Gordinflon", "Zampabollos");
        UsuarioFactura u2 = new UsuarioFactura("Perico", "Delospalotes");

        Factura f1 = new Factura("Factura1");
        Factura f2 = new Factura("Factura2");
        Factura f3 = new Factura("Factura3");
        Factura f4 = new Factura("Factura4");
        Factura f5 = new Factura("Factura5");
        Factura f6 = new Factura("Factura6");

        u1.addFacturas(f1);
        u1.addFacturas(f2);
        u1.addFacturas(f3);

        u2.addFacturas(f4);
        u2.addFacturas(f5);
        u2.addFacturas(f6);

        List<UsuarioFactura> usuariosFacturas = Arrays.asList(u1, u2);


        List<Factura> listadoTotalFacturas = usuariosFacturas.stream()
                .flatMap(it -> it.getFacturas().stream())
                .toList();

        listadoTotalFacturas.forEach(it -> System.out.println(it.getDescripcion() + "-> Cliente: " + it.getUsuarioFactura().toString()));
    }
}
