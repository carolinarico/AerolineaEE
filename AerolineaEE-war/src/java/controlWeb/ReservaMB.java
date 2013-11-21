/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlWeb;

import ejb.CiudadEJB;
import ejb.ClienteEJB;
import ejb.ReservaEJB;
import ejb.VueloEJB;
import entidad.Ciudad;
import entidad.Cliente;
import entidad.Reserva;
import entidad.Vuelo;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
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
public class ReservaMB {

    @EJB
    private ReservaEJB resEJB;
    @EJB
    private VueloEJB vueEJB;
    @EJB
    private ClienteEJB clienEJB;
    @EJB
    private CiudadEJB ciuEJB;
    private Reserva reserva;
    private String mensaje;
    private List<Reserva> reservas;
    private List<Ciudad> ciudades;
    private List<Vuelo> vuelos, vuelosR, vuelosNR, vuelosCliente;
    private HtmlDataTable reservaSelect, vueloNRSelect, vueloRSelect;
    private Ciudad origen, destino;
    private Vuelo vuelo;
    private int idcity1, idcity2;
    private int idUsuario;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ReservaEJB getResEJB() {
        return resEJB;
    }

    public void setResEJB(ReservaEJB resEJB) {
        this.resEJB = resEJB;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public HtmlDataTable getReservaSelect() {
        return reservaSelect;
    }

    public void setReservaSelect(HtmlDataTable reservaSelect) {
        this.reservaSelect = reservaSelect;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Vuelo> getVuelosCliente() {
        return vuelosCliente;
    }

    public void setVuelosCliente(List<Vuelo> vuelosCliente) {
        this.vuelosCliente = vuelosCliente;
    }

    public List<Vuelo> getVuelosNR() {
        return vuelosNR;
    }

    public void setVuelosNR(List<Vuelo> vuelosNR) {
        this.vuelosNR = vuelosNR;
    }

    public List<Vuelo> getVuelosR() {
        return vuelosR;
    }

    public void setVuelosR(List<Vuelo> vuelosR) {
        this.vuelosR = vuelosR;
    }

    public HtmlDataTable getVueloNRSelect() {
        return vueloNRSelect;
    }

    public void setVueloNRSelect(HtmlDataTable vueloNRSelect) {
        this.vueloNRSelect = vueloNRSelect;
    }

    public HtmlDataTable getVueloRSelect() {
        return vueloRSelect;
    }

    public void setVueloRSelect(HtmlDataTable vueloRSelect) {
        this.vueloRSelect = vueloRSelect;
    }

//    public String crearReserva(){        
//        if(resEJB.crearReserva(reserva)==true){
//            mensaje="Reserva realizada exitosamente";
//        }else{
//            mensaje="Reserva no realizada";
//        }
//        reservas = new ArrayList<Reserva>();
//        reservas = resEJB.obtenerReservas();
//        return "listaReserva.xhtml";
//    }
//    
//    public String mostrarFormCrearReserva(){
//        mensaje = " ";
//        reserva = new Reserva();
//        return "formCrearReserva.xhtml";
//    }
    public String mostrarListaReserva() {
        mensaje = " ";
        reservas = new ArrayList<Reserva>();
        reservas = resEJB.obtenerReservas();
        return "listaReserva.xhtml";
    }

    public String mostrarFormGestionReserva() {
        vuelo = new Vuelo();
        this.listarCiudades();
        this.listarVuelos();
        reserva = new Reserva();
        return "formGestionReserva.xhtml";

    }

    public void obtenerCiudadesSeleccionadas() {
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

    public void listarVuelos() {
        vuelos = new ArrayList<Vuelo>();
        vuelos = vueEJB.obtenerVuelos();

        vuelosCliente = new ArrayList<Vuelo>();
        reservas = new ArrayList<Reserva>();
        reservas = resEJB.obtenerReservaByCliente(idUsuario);
        for (int i = 0; i < reservas.size(); i++) {
            vuelosCliente.add(reservas.get(i).getIdvuelo());
        }
    }

    public String realizarReserva() {
        reserva = new Reserva();
        reserva.setIdcliente(new Cliente((short) idUsuario));
        Vuelo v = new Vuelo();
        v = (Vuelo) vueloNRSelect.getRowData();
        reserva.setIdvuelo(v);
        reserva.setFechar(new Date());
        if (resEJB.crearReserva(reserva) == true) {
            mensaje = "Reserva creada";
        } else {
            mensaje = "Reserva no creada";
        }
        return buscarVuelos();
    }

    public String eliminarReserva() {
        reserva = new Reserva();
        Vuelo v = new Vuelo();
        v = (Vuelo) vueloRSelect.getRowData();
        reserva = resEJB.reservaByClienteYViaje(idUsuario, v.getIdvuelo());
        if (resEJB.eliminarReserva(reserva) == true) {
            mensaje = "Reserva eliminada";
        } else {
            mensaje = "Reserva no eliminada";
        }
        return buscarVuelos();
    }

    public String buscarVuelos() {
        this.obtenerCiudadesSeleccionadas();
        this.listarVuelos();
        System.out.println("Vuelos: " + vuelos.size());
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        vuelosR = new ArrayList<Vuelo>();
        vuelosNR = new ArrayList<Vuelo>();

        for (int i = 0; i < vuelos.size(); i++) {
            Vuelo v = new Vuelo();
            v = vuelos.get(i);
            System.out.println("Vuelo antes: " + v.getCodigo());
            if (v.getOrigen().getIdciudad() == origen.getIdciudad() && v.getDestino().getIdciudad() == destino.getIdciudad()) {
                System.out.println("Vuelo cumple: " + v.getCodigo());
                if (vuelosCliente.contains(v)) {
                    System.out.println("R: " + v);
                    vuelosR.add(v);
                } else {
                    System.out.println("NoR: " + v);
                    vuelosNR.add(v);
                }
            }
        }
        return "formGestionReserva.xhtml";
    }
//    
//    public String mostrarFormEditarVuelo(){
//        vuelo = new Vuelo();
//        vuelo = (Vuelo) vueloSelect.getRowData();
//        return "formEditarVuelo.xhtml";
//    }
//    
//    public String editarVuelo(){
//        mensaje="";
//        if(vueEJB.editarVuelo(vuelo)==true){
//            mensaje = "Vuelo Editado";
//        }else{
//            mensaje = "Vuelo No Editado";
//        }
//        vuelos = new ArrayList<Vuelo>();
//        vuelos = vueEJB.obtenerVuelos();
//        return "listaVuelo.xhtml";        
//    }
//    
//    public String mostrarFormEliminarVuelo(){
//        mensaje = " ";
//        vuelo = new Vuelo();
//        vuelo = (Vuelo) vueloSelect.getRowData();
//        return "formEliminarVuelo.xhtml";
//    }
//    
//    public String eliminarVuelo(){
//        mensaje="";
//        if(vueEJB.eliminarVuelo(vuelo)==true){
//            mensaje = "Vuelo Eliminado";
//        }else{
//            mensaje = "Vuelo No Eliminado";
//        }
//        vuelos = new ArrayList<Vuelo>();
//        vuelos = vueEJB.obtenerVuelos();
//        return "listaVuelo.xhtml";
//    }

    /**
     * Creates a new instance of ReservaMB
     */
    public ReservaMB() {
    }
}
