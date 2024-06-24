
package mrysi.Beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author tibur
 */
public class Entidad implements Serializable {
    
  private int idEntidad;
  private String nombreEntidad;
  
  public Entidad(){}
  
  public Entidad(int idEntidad, String nombreEntidad){
      this.idEntidad = idEntidad;
      this.nombreEntidad = nombreEntidad;
  }
 public int getIdEntidad(){
     return idEntidad;
 }
    public String getNombreEntidad(){
        return nombreEntidad;
    }
    public void setIdEntidad(int idEntidad){
        this.idEntidad = idEntidad;
    }
    public void setNombreEntidad(String nombreEntidad){
        this.nombreEntidad = nombreEntidad;
    }
}
