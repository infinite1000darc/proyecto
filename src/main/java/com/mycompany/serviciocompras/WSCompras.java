/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.serviciocompras;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author drdav
 */
@WebService(serviceName = "WSCompras")
public class WSCompras {

    /**
     * This is a sample web service operation
     * @param nombreCliente
     * @param email
     * @param direccion
     * @param rfc
     * @param nombreProducto
     * @param cantidadProducto
     * @param precioProducto
     */
    @WebMethod(operationName = "RecibirCompraRequest")
    public Integer RecibirCompraRequest(
            @WebParam(name = "nombreCliente") String nombreCliente, 
            @WebParam(name = "email") String email,
            @WebParam(name = "direccion") String direccion, 
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "nombreProducto") String nombreProducto, 
            @WebParam(name = "cantidadProducto") int cantidadProducto,
            @WebParam(name = "precioProducto") float precioProducto) {
        
        int folio = 0;
        
        Dao dao = new Dao();
        Compra compra = new Compra(nombreCliente,email,direccion,rfc,nombreProducto,
                cantidadProducto,
                precioProducto);
        
        try {
            folio = dao.añadir(compra);
        } catch (SQLException ex) {
            Logger.getLogger(WSCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return folio;
    }
    
    @WebMethod(operationName = "EstadoCompraRequest")
    public String EstadoCompraRequest(@WebParam(name = "folioSeguimiento") int folioSeguimiento){
        String estado = "";
        Dao dao = new Dao();
        try {
            estado = dao.obtenerEstado(folioSeguimiento);
        } catch (SQLException ex) {
            Logger.getLogger(WSCompras.class.getName()).log(Level.SEVERE, null, ex);
            estado = "compra no encontrada";
        }
        return estado;
    }
    
    @WebMethod(operationName = "cancelarCompra")
    public String CancelarCompraRequest(@WebParam(name = "folioSeguimiento") int folioSeguimiento){
        String respuesta = "";
        Dao dao = new Dao();
        try {
            dao.cancelarCompra(folioSeguimiento);
            respuesta = "compra" + folioSeguimiento + "cancelada.";
        } catch (SQLException ex) {
            Logger.getLogger(WSCompras.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = "La compra no se pudo cancelar.";
        }
        return respuesta;
    }
}
