/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviciocompras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author drdav
 */
public class Dao {
  private final Conexion con;
  private Connection connection;
  private PreparedStatement ps;
  private ResultSet rs;
  private Statement st;
  
  public Dao(){
      con=new Conexion();
  }
  
  public int añadir(Compra compra) throws SQLException{
    int folio;
    connection = con.obtenerConexion();
    String consulta = "INSERT INTO compra "
            + "(nombreCliente,email,direccion,rfc,nombreProducto,,cantidadProducto,precioProducto,estado)\n" +
"  values (?,?,?,?,?,?,?,?);";
    ps = connection.prepareStatement(consulta);
    ps.setString(1, compra.getNombreCliente());
    ps.setString(2, compra.getEmail());
    ps.setString(3, compra.getDireccion());
    ps.setString(4, compra.getRfc());
    ps.setString(5, compra.getNombreProducto());
    ps.setInt(6, compra.getCantidadProducto());
    ps.setFloat(7, compra.getPrecioProducto());
    ps.setString(8, "en Espera");
    ps.execute();
    connection.close();
    return obtenerUltimoFolio();
  }
  
  public int obtenerUltimoFolio() throws SQLException{
      int folio = 0;
      
      String consulta = "SELECT * FROM compra";
      connection = con.obtenerConexion();
      st = connection.createStatement();
      rs = st.executeQuery(consulta);
      while(rs.next()){
          folio++;
      }
      
      return folio;
  }
  
  public void cancelarCompra(int folio) throws SQLException{
    connection = con.obtenerConexion();
    String consulta = "Update compra "
            + "set estado = ?"
            + "where folio = ? ;";
    ps = connection.prepareStatement(consulta);
    ps.setString(1, "cancelado");
    ps.setInt(2, folio);
    ps.execute();
    connection.close();
  }
  
  public String obtenerEstado(int folio) throws SQLException{
      String estado = "";
      String consulta = "SELECT estado FROM compra where folio = " + folio;
      connection = con.obtenerConexion();
      st = connection.createStatement();
      rs = st.executeQuery(consulta);
      while(rs.next()){
          estado = rs.getString("estado");
      }
      connection.close();
      return estado;
  }
}
