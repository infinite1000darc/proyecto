package com.tuempresa.webservice;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "com.tuempresa.webservice.CompraService")
public class CompraServiceImpl implements CompraService {

    private Map<String, String> compras = new HashMap<>();

    @Override
    public String recibirCompra(String nombreCliente, String email, String direccion, String rfc, String nombreProducto, int cantidadProducto, double precioProducto) {
        String folio = "COMPRA" + (compras.size() + 1);
        compras.put(folio, "Recibida");
        // Aquí podrías agregar la lógica para almacenar la compra en una base de datos
        return folio;
    }

    @Override
    public String cancelarCompra(String folio) {
        if (compras.containsKey(folio)) {
            compras.put(folio, "Cancelada");
            return "Compra cancelada";
        } else {
            return "Folio no encontrado";
        }
    }

    @Override
    public String estadoCompra(String folio) {
        return compras.getOrDefault(folio, "Folio no encontrado");
    }
}

