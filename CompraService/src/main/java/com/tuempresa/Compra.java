package com.tuempresa.webservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCliente;
    private String email;
    private String direccion;
    private String rfc;
    private String nombreProducto;
    private int cantidadProducto;
    private double precioProducto;

    // Getters y setters

}
