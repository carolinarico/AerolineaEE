/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlWeb;

import ejb.ClienteEJB;
import entidad.Cliente;
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
public class ClienteMB {
    
    @EJB
    private ClienteEJB clienEJB;
    
    private Cliente cliente;
    private String mensaje;
    private List <Cliente> clientes;
    private HtmlDataTable clienteSelect;
    private String login = "", password = "";
    private int idLogin = 0;

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
    
     
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public HtmlDataTable getClienteSelect() {
        return clienteSelect;
    }

    public void setClienteSelect(HtmlDataTable clienteSelect) {
        this.clienteSelect = clienteSelect;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    
    public String crearCliente(){        
        if(clienEJB.crearCliente(cliente)==true){
            mensaje="Cliente creado exitosamente";
        }else{
            mensaje="Cliente no creado";
        }
        clientes = new ArrayList<Cliente>();
        clientes = clienEJB.obtenerClientes();
        return "listaCliente.xhtml";
    }
    
    public String mostrarFormCrearCliente(){
        mensaje = " ";
        cliente = new Cliente();
        return "formCrearCliente.xhtml";
    }
    
    public String mostrarListaCliente(){
        mensaje = " ";
        clientes = new ArrayList<Cliente>();
        clientes = clienEJB.obtenerClientes();
        return "listaCliente.xhtml";
    }
    
    public String mostrarFormEditarCliente(){
        cliente = new Cliente();
        cliente = (Cliente) clienteSelect.getRowData();
        return "formEditarCliente.xhtml";
    }
    
    public String editarCliente(){
        mensaje="";
        if(clienEJB.editarCliente(cliente)==true){
            mensaje = "Cliente Editado";
        }else{
            mensaje = "Cliente No Editado";
        }
        clientes = new ArrayList<Cliente>();
        clientes = clienEJB.obtenerClientes();
        return "listaCliente.xhtml";
        
    }
    
    public String mostrarFormEliminarCliente(){
        mensaje = " ";
        cliente = new Cliente();
        cliente = (Cliente) clienteSelect.getRowData();
        return "formEliminarCliente.xhtml";
    }
    
    public String eliminarCliente(){
        mensaje="";
        if(clienEJB.eliminarCliente(cliente)==true){
            mensaje = "Cliente Eliminado";
        }else{
            mensaje = "Cliente No Eliminado";
        }
        clientes = new ArrayList<Cliente>();
        clientes = clienEJB.obtenerClientes();
        return "listaCliente.xhtml";
    }
    
    public String inicioSesionCliente(){
        clientes = new ArrayList<Cliente>();
        clientes = clienEJB.obtenerClientes();
        boolean exist = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getLogin().equals(login) && clientes.get(i).getPassword().equals(password)) {
                cliente = clientes.get(i);
                exist = true;
                break;
            }
        }
        login = "";
        password = "";
        if (exist) {
            idLogin = 1;
            return "sesionCliente.xhtml";
        } else {
            idLogin = 0;
            mensaje = "Login o Password incorrectos";
            return "ingresarCliente.xhtml";
        }
    }
    
    public String cerrarSesionCliente(){
        cliente = new Cliente();
        idLogin = 0;
        return "index.xhtml";
    }

    /**
     * Creates a new instance of ClienteMB
     */
    public ClienteMB() {
    }
}
