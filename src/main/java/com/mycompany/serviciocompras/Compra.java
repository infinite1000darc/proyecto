/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviciocompras;

/**
 *
 * @author drdav
 */
public class Compra {
    private int folio;
    private String nombreCliente, email,direccion,rfc,nombreProducto;
    private int cantidadProducto;
    private float precioProducto;

    public Compra() {
    }

    public Compra(String nombreCliente, String email, String direccion, String rfc, String nombreProducto, int cantidadProducto, float precioProducto) {
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.direccion = direccion;
        this.rfc = rfc;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }
    
    

    public Compra(int folio, String nombreCliente, String email, String direccion, String rfc, String nombreProducto, int cantidadProducto, float precioProducto) {
        this.folio = folio;
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.direccion = direccion;
        this.rfc = rfc;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }
    
    

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
}
