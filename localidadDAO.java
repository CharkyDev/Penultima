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
public interface localidadDAO {
    public void insert(Localidad localidad) throws SQLException;
    public void update(Localidad localidad) throws SQLException;
    public void delete(Integer id) throws SQLException;
    public Localidad read(Integer id) throws SQLException;
    public List<Localidad> readAll() throws SQLException;
}
