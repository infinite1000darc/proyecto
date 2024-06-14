package com.tuempresa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Optional;

@WebService
public class CompraServiceEndpoint {

    private final CompraService compraService;

    public CompraServiceEndpoint(CompraService compraService) {
        this.compraService = compraService;
    }

    @WebMethod
    public Compra recibirCompra(@WebParam(name = "nombreCliente") String nombreCliente,
                                @WebParam(name = "email") String email,
                                @WebParam(name = "direccion") String direccion,
                                @WebParam(name = "rfc") String rfc,
                                @WebParam(name = "nombreProducto") String nombreProducto,
                                @WebParam(name = "cantidadProducto") int cantidadProducto,
                                @WebParam(name = "precioProducto") double precioProducto) {
        Compra compra = new Compra();
        compra.setNombreCliente(nombreCliente);
        compra.setEmail(email);
        compra.setDireccion(direccion);
        compra.setRfc(rfc);
        compra.setNombreProducto(nombreProducto);
        compra.setCantidadProducto(cantidadProducto);
        compra.setPrecioProducto(precioProducto);
        return compraService.recibirCompra(compra);
    }

    @WebMethod
    public String cancelarCompra(@WebParam(name = "id") Long id) {
        boolean result = compraService.cancelarCompra(id);
        return result ? "Compra cancelada" : "Compra no encontrada";
    }

    @WebMethod
    public Compra estadoCompra(@WebParam(name = "id") Long id) {
        Optional<Compra> compra = compraService.estadoCompra(id);
        return compra.orElse(null);
    }
}
