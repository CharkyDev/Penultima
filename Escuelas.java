package mrysi.Beans;

/**
 *
 * @author tibur
 */
public class Escuelas implements java.io.Serializable {
    
    
    private String claveEscuela;
    private String nombreEscuela;
    private String domicilio;
    private int codigoPostal;
    private String turno;
    private int idLocalidad;
    
    
    
    public void setClaveEscuela(String claveEscuela){
        this.claveEscuela = claveEscuela;
    }
    public void setNombreEscuela(String nombreEscuela){
        this.nombreEscuela = nombreEscuela;
    }
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
    
    public void setCodigoPostal(int codigoPostal){
        this.codigoPostal = codigoPostal;
    }
    public void setTurno(String turno){
        this.turno = turno;
    }
    public void setIdLocalidad(int idLocalidad){
        this.idLocalidad = idLocalidad;
    }
    public String getClaveEscuela(){
        return claveEscuela;
    }
    public String getNombreEscuela(){
        return nombreEscuela;
    }
    public String getDomicilio(){
        return domicilio;
    }
    public int getCodigoPostal(){
        return codigoPostal;
    }
    public String getTurno(){
        return turno;
    }
    public int getIdLocalidad(){
        return idLocalidad;
    }
}
