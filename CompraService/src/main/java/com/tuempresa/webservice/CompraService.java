package com.tuempresa.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CompraService {

    @WebMethod
    String recibirCompra(
        @WebParam(name = "nombreCliente") String nombreCliente,
        @WebParam(name = "email") String email,
        @WebParam(name = "direccion") String direccion,
        @WebParam(name = "rfc") String rfc,
        @WebParam(name = "nombreProducto") String nombreProducto,
        @WebParam(name = "cantidadProducto") int cantidadProducto,
        @WebParam(name = "precioProducto") double precioProducto
    );

    @WebMethod
    String cancelarCompra(@WebParam(name = "folio") String folio);

    @WebMethod
    String estadoCompra(@WebParam(name = "folio") String folio);
}

