/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlWeb;

import ejb.AdminEJB;
import entidad.AdminA;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author EST
 */
@ManagedBean
@SessionScoped
public class AdminMB {
    
    @EJB
    private AdminEJB admEJB;    
    private AdminA admin;
    private String mensaje;
    private String login="", password="";
    private int idLogin = 0;

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
    
    
    public AdminA getAdmin() {
        return admin;
    }

    public void setAdmin(AdminA admin) {
        this.admin = admin;        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
//    public String ingresarAdmin(){
//        if(admEJB.obtenerAdmin(admin)==true){
//            return "sesionAdmin.xhtml";
//        }else{
//            System.out.println("No valido");
//        }return "ingresarAdmin.xhtml";
//    }
    
    public String inicioSesionAdmin(){
        List<AdminA> ad = new ArrayList<AdminA>();
        ad = admEJB.obtenerAdministrador();
        boolean exist = false;
        for (int i = 0; i < ad.size(); i++) {
            if (ad.get(i).getLogin().equals(login) && ad.get(i).getPassword().equals(password)) {
                admin = ad.get(i);
                exist = true;
                break;
            }
        }
        login = "";
        password = "";
        if (exist) {
            idLogin = 1;
            return "sesionAdmin.xhtml";
            
        } else {
            idLogin = 0;
            mensaje = "Login o Password incorrectos";
            return "ingresarAdmin.xhtml";
        }
    }
    
    public String cerrarSesionAdmin(){
        admin = new AdminA();
        idLogin = 0;
        return "index.xhtml";
    }
    
    

    /**
     * Creates a new instance of AdminMB
     */
    public AdminMB() {
        
        
    }
}
