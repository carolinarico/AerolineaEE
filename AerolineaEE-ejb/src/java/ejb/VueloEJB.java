/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Ciudad;
import entidad.Vuelo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author EST
 */
@Stateless
@LocalBean
public class VueloEJB {
    
    @PersistenceContext(unitName="AerolineaEE-ejbPU")
    private EntityManager em;
    
    public boolean crearVuelo(Vuelo v){        
        try{
            em.persist(v);
        }catch(Exception e){
           e.printStackTrace();
            return false;
        }
    return true;
    }
    
    public List <Vuelo> obtenerVuelos(){
        List <Vuelo> vuelos = new ArrayList<Vuelo>();
        Query q = em.createNamedQuery("Vuelo.findAll");
        try{
            vuelos = q.getResultList();
            }catch(javax.persistence.NoResultException e){
            return null;
        }
        return vuelos;
    }
    
    public List <Ciudad> seleccionarVuelos(){
        List <Ciudad> vueloC = new ArrayList<Ciudad>();
        Query q = em.createNamedQuery("Ciudad.findAll");
        try{
            vueloC = q.getResultList();
            }catch(javax.persistence.NoResultException e){
            return null;
        }
        return vueloC;
    }
    
    public boolean editarVuelo(Vuelo v){
        try{
            em.merge(v);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean eliminarVuelo(Vuelo v){
        try{
            em.remove(em.merge(v));
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
	
	
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
