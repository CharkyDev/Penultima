/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mrysi.Beans;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tibur
 */
public interface EntidadDAO {
    public void insert(Entidad entidad) throws SQLException;
    public void update(Entidad entidad) throws SQLException;
    public void delete(Integer id) throws SQLException;
    public Entidad read(Integer id) throws SQLException;
    public List<Entidad> readAll() throws SQLException;
    
}
