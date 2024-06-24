/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package mrysi.Beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author tibur
 */
public class Localidad implements Serializable {
    private int idLocalidad;
    private String nombreLocalidad;
    private int idEntidad;
    private Entidad entidad;
    
    public Localidad(Integer id, String string, int aInt){}
    
    public Localidad(int idLocalidad, String nombreLocalidad,
            int idEntidad, Entidad Entidad){
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
        this.idEntidad = idEntidad;
        this.entidad = Entidad;
    }
     public int getIdLocalidad(){
     return idLocalidad;
 }
    public String getNombreLocalidad(){
        return nombreLocalidad;
    }
    public int getIdEntidad(){
        return idEntidad;
    }
    public void setIdEntidad(int idEntidad){
        this.idEntidad = idEntidad;
    }
    public void setNombreLocalidad(String nombreEntidad){
        this.nombreLocalidad = nombreLocalidad;
    }
    public void setEntidad(Entidad entidad){
        this.entidad = entidad;
    }
    
}
