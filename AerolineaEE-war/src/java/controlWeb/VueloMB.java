/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlWeb;

import ejb.CiudadEJB;
import ejb.VueloEJB;
import entidad.Ciudad;
import entidad.Vuelo;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author EST
 */
@ManagedBean
@SessionScoped
public class VueloMB {

    @EJB
    private VueloEJB vueEJB;
    @EJB
    private CiudadEJB ciuEJB;
    
    private Vuelo vuelo;
    private List<Vuelo> vuelos;
    private List<Ciudad> ciudades;
    private HtmlDataTable vueloSelect;
    private int idcity1, idcity2;
    private String mensaje;
    private Ciudad origen, destino, city;
    
    

    public Ciudad getCity() {
        return city;
    }

    public void setCity(Ciudad city) {
        this.city = city;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public int getIdcity1() {
        return idcity1;
    }

    public void setIdcity1(int idcity1) {
        this.idcity1 = idcity1;
    }

    public int getIdcity2() {
        return idcity2;
    }

    public void setIdcity2(int idcity2) {
        this.idcity2 = idcity2;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public HtmlDataTable getVueloSelect() {
        return vueloSelect;
    }

    public void setVueloSelect(HtmlDataTable vueloSelect) {
        this.vueloSelect = vueloSelect;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public String crearVuelo() {
        this.obtenerCiudadesSeleccionadas();
        vuelo.setDestino(destino);
        vuelo.setOrigen(origen);
        //System.out.println("\n"+vuelo.getCodigo()+ "\n"+vuelo.getFechav()+ "\n"+vuelo.getOrigen()+ "\n"+vuelo.getDestino());
        if (vueEJB.crearVuelo(vuelo) == true) {
            mensaje = "Vuelo creado exitosamente";
        } else {
            mensaje = "Vuelo no creado";
        }
        vuelos = new ArrayList<Vuelo>();
        vuelos = vueEJB.obtenerVuelos();
        return "listaVuelo.xhtml";
    }

    public String mostrarFormCrearVuelo() {
        mensaje = " ";
        vuelo = new Vuelo();
        return "formCrearVuelo.xhtml";
    }

    public String mostrarListaVuelo() {
        mensaje = " ";
        vuelos = new ArrayList<Vuelo>();
        vuelos = vueEJB.obtenerVuelos();
        this.listarCiudades();
        return "listaVuelo.xhtml";
    }

    public String mostrarFormEditarVuelo() {
        this.listarCiudades();
        vuelo = new Vuelo();
        vuelo = (Vuelo) vueloSelect.getRowData();
        idcity1 = vuelo.getOrigen().getIdciudad();
        idcity2 = vuelo.getDestino().getIdciudad();
        return "formEditarVuelo.xhtml";
    }

    public String editarVuelo() {
        this.obtenerCiudadesSeleccionadas();
        vuelo.setOrigen(origen);
        vuelo.setDestino(destino);
        mensaje = "";
        if (vueEJB.editarVuelo(vuelo) == true) {
            mensaje = "Vuelo Editado";
        } else {
            mensaje = "Vuelo No Editado";
        }
        vuelos = new ArrayList<Vuelo>();
        vuelos = vueEJB.obtenerVuelos();
        return "listaVuelo.xhtml";
    }

    public String mostrarFormEliminarVuelo() {
        mensaje = " ";
        vuelo = new Vuelo();
        vuelo = (Vuelo) vueloSelect.getRowData();
        return "formEliminarVuelo.xhtml";
    }

    public String eliminarVuelo() {
        mensaje = "";
        if (vueEJB.eliminarVuelo(vuelo) == true) {
            mensaje = "Vuelo Eliminado";
        } else {
            mensaje = "Vuelo No Eliminado";
        }
        vuelos = new ArrayList<Vuelo>();
        vuelos = vueEJB.obtenerVuelos();
        return "listaVuelo.xhtml";
    }

    public void obtenerCiudadesSeleccionadas(){
        destino = new Ciudad();
        destino = ciuEJB.obtenerCiudadById(idcity2);
        origen = new Ciudad();
        origen = ciuEJB.obtenerCiudadById(idcity1);
    }


    public void listarCiudades() {
        ciudades = new ArrayList<Ciudad>();
        ciudades = ciuEJB.obtenerCiudades();
        try {
            idcity1 = ciudades.get(0).getIdciudad();
            idcity2 = ciudades.get(0).getIdciudad();
        } catch (Exception e) {
            idcity1 = 1;
            idcity2 = 1;
        }
    }
    
    public Date getToday() {
		return (new Date());
	}
    
    public Date getFechaVuelo() {
		Date fecha;
		try {
                    fecha = new SimpleDateFormat("dd/MM/yyyy").parse(this.vuelo.getFechav());
		} catch (NullPointerException e1) {
			fecha = new Date();
		} catch (ParseException e2) {
			fecha = new Date();
		}
		return fecha;
	}

	public void setFechaVuelo(Date fechav) {
		this.vuelo.setFechav(fechav);
	}

    public VueloMB() {
    }

}
