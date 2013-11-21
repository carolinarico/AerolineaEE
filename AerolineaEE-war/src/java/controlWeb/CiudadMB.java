/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlWeb;

import ejb.CiudadEJB;
import entidad.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

/**
 *
 * @author EST
 */
@ManagedBean
@SessionScoped
public class CiudadMB {
    
    @EJB
    private CiudadEJB ciudEJB;
    
    private Ciudad ciudad;
    private String mensaje;
    private List <Ciudad> ciudades;
    private HtmlDataTable ciudadSelect;

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HtmlDataTable getCiudadSelect() {
        return ciudadSelect;
    }

    public void setCiudadSelect(HtmlDataTable ciudadSelect) {
        this.ciudadSelect = ciudadSelect;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    
    
    
    public String crearCiudad(){        
        if(ciudEJB.crearCiudad(ciudad)==true){
            mensaje="Ciudad creada exitosamente";
        }else{
            mensaje="Ciudad no creada";
        }
        ciudades = new ArrayList<Ciudad>();
        ciudades = ciudEJB.obtenerCiudades();
        return "listaCiudad.xhtml";
    }
    
    public String mostrarFormCrearCiudad(){
        mensaje=" ";
        ciudad= new Ciudad();
        return "formCrearCiudad.xhtml";
    }
    
    public String mostrarListaCiudad(){
        mensaje = " ";
        ciudades = new ArrayList<Ciudad>();
        ciudades = ciudEJB.obtenerCiudades();
        return "listaCiudad.xhtml";
    }
    
    public String mostrarFormEditarCiudad(){
        ciudad = new Ciudad();
        ciudad = (Ciudad) ciudadSelect.getRowData();
        return "formEditarCiudad.xhtml";
    }
    
    public String editarCiudad(){
        if(ciudEJB.editarCiudad(ciudad)==true){
            mensaje = "Ciudad Editada";
        }else{
            mensaje = "Ciudad No Editada";
        }
        ciudades = new ArrayList<Ciudad>();
        ciudades = ciudEJB.obtenerCiudades();
        return "listaCiudad.xhtml";
    }
    
    public String mostrarFormEliminarCiudad(){
        mensaje = " ";
        ciudad = new Ciudad();
        ciudad = (Ciudad) ciudadSelect.getRowData();
        return "formEliminarCiudad.xhtml";
    }
    
    public String eliminarCiudad(){
        if(ciudEJB.eliminarCiudad(ciudad)==true){
            mensaje = "Ciudad Eliminada";
        }else{
            mensaje = "Ciudad No Eliminada";
        }
        ciudades = new ArrayList<Ciudad>();
        ciudades = ciudEJB.obtenerCiudades();
        return "listaCiudad.xhtml";
    }
    
      

    /**
     * Creates a new instance of CiudadMB
     */
    public CiudadMB() {
    }
}
