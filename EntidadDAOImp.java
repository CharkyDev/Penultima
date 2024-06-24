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
public class EntidadDAOImp implements EntidadDAO {
    private String Table_Name;
    private ConexionMySQL conMySQL;
    private Connection conn;
    
    public EntidadDAOImp(){
        Table_Name = "Entidades";
        conMySQL = new ConexionMySQL();
    }
    
    public void insert(Entidad entidad) throws SQLException{
        conn = conMySQL.getConnection();
        String insertQuery = "INSERT INTO"+Table_Name+"(nombreEntidad)"
                + "VALUES(?)";
        try(PreparedStatement ps = conn.prepareStatement(insertQuery)){
            ps.setString(1,entidad.getNombreEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }
    public void update(Entidad entidad) throws SQLException{
        conn = conMySQL.getConnection();
        String updateQuery = "UPDATE"+Table_Name
                +"SET nombreEntidad = ?"
                +"WHERE idEntidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(updateQuery)){
            ps.setString(1,entidad.getNombreEntidad());
            ps.setInt(2,entidad.getIdEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }
    public void delete(Integer id)throws SQLException{
        conn = conMySQL.getConnection();
        String deletQuery = "DELETE FROM"+Table_Name
                +"WHERE idEntidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(deletQuery)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        conn.close();
    }
    public Entidad read(Integer id)throws SQLException{
        Entidad entidad = null;
        conn = conMySQL.getConnection();
        String Query = "SELECT idEntidad, "
                +"nombreEntidad FROM"+Table_Name
                +"WHERE idEntidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    entidad = new Entidad(id,
                    rs.getString("nombreEntidad"));
                }
            }
        }
        return entidad;
    }
    
    public List<Entidad> readAll() throws SQLException{
        List<Entidad> entidades = new ArrayList();
        conn = conMySQL.getConnection();
        String Query = "SELECT idEntidad,"
                + "nombreEntidad FROM"+Table_Name;
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Entidad entidad = new Entidad(
                    rs.getInt("idEntidad"),
                    rs.getString("nombreEntidad"));
                    entidades.add(entidad);
                }
            }
        }
        return entidades;
    }
}
