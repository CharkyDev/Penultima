/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package mrysi.Beans;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mrysi.servlet.ConexionMySQL;

/**
 *
 * @author tibur
 */
public class localidadDAOImp implements localidadDAO {
    private String Table_Name;
    private ConexionMySQL conMySQL;
    private Connection conn;
    
    public localidadDAOImp(){
        Table_Name = "Entidades";
        conMySQL = new ConexionMySQL();
    }
    
    public void insert(Localidad localidad) throws SQLException{
        conn = conMySQL.getConnection();
        String insertQuery = "INSERT INTO"+Table_Name+"(nombreLocalidad)"
                + "VALUES(?)";
        try(PreparedStatement ps = conn.prepareStatement(insertQuery)){
            ps.setString(1,localidad.getNombreLocalidad());
            ps.setInt(2,localidad.getIdEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }
    public void update(Localidad entidad) throws SQLException{
        conn = conMySQL.getConnection();
        String updateQuery = "UPDATE"+Table_Name
                +"SET nombreEntidad = ?"
                +"WHERE idEntidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(updateQuery)){
            ps.setString(1,entidad.getNombreLocalidad());
            ps.setInt(2,entidad.getIdLocalidad());
            ps.executeUpdate();
        }
        conn.close();
    }
     public void delete(Integer id)throws SQLException{
        conn = conMySQL.getConnection();
        String deletQuery = "DELETE FROM"+Table_Name
                +"WHERE idLocalidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(deletQuery)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        conn.close();
    }
    @Override
    public Localidad read(Integer id) throws SQLException {
        Localidad localidad = null;
        EntidadDAOImp edi = new EntidadDAOImp();
        conn = conMySQL.getConnection();
        String Query = "SELECT idLocalidad, "
                +"nombreLocalidad, idEntidad FROM"+Table_Name
                +"WHERE idLocalidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    localidad = new Localidad(id, rs.getString("nombreLocalidad"),
                    rs.getInt("idEntidad"));
                    localidad.setEntidad(edi.read(rs.getInt("idEntidad")));
                }
            }
        }
        return localidad;
    }

    @Override
    public List<Localidad> readAll() throws SQLException {
       List<Localidad> localidades = new ArrayList();
       conn = conMySQL.getConnection();
       String Query = "SELECT l.idlocalidad, "
               +"l.nombreLocalidad, l.idEntidad,e.nombreEntidad"+
               "FROM Localidades l JOIN Entidades e"
               +"ON l.idEntidad = e.idEntidades";
       try(PreparedStatement ps = conn.prepareStatement(Query)){
           try(ResultSet rs = ps.executeQuery()){
               while(rs.next()){
                   Localidad localidad = new Localidad(
                   rs.getInt("idLocalidad"),
                   rs.getString("nombreLocalidad"),
                   rs.getInt("idEntidad"));
                   localidad.setEntidad(new Entidad(rs.getInt("idEntidad"),
                   rs.getString("nombreEntidad")));
                   localidades.add(localidad);
               }
           }
       }
       return localidades;
    }
    
}
