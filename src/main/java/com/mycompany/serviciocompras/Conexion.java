/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviciocompras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drdav
 */
public class Conexion {
    private Connection conexion;
    String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql:// localhost:3306/compras";
    private final String USUARIO="root";
    private final String CONTRASENA="12345";
    
    public Connection obtenerConexion() throws SQLException{
        conecta();
        return conexion;
    }
    
    private void conecta() throws SQLException{
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
      conexion=DriverManager.getConnection(url,USUARIO,CONTRASENA);
    }
    
    public void cerrarConexion(){
        if(conexion!=null){
            try {
                if(!conexion.isClosed()){
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
