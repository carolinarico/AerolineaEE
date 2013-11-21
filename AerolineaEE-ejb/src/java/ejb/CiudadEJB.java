/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Ciudad;
import java.util.ArrayList;
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
public class CiudadEJB {
    
    @PersistenceContext(unitName="AerolineaEE-ejbPU")
    private EntityManager em;
    
    public boolean crearCiudad(Ciudad c){        
        try{
            em.persist(c);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    return true;
    }
    
    public List <Ciudad> obtenerCiudades(){
        List <Ciudad> ciudades = new ArrayList<Ciudad>();
        Query q = em.createNamedQuery("Ciudad.findAll");
        try{
            ciudades = q.getResultList();
        }catch(javax.persistence.NoResultException e){
            return null;
        }
        return ciudades;
    }
    
     public Ciudad obtenerCiudadById(int id){
        Ciudad ciudad = new Ciudad();
        Query q = em.createNamedQuery("Ciudad.findByIdciudad");
        q.setParameter("idciudad", new Integer(id));
        try{
            ciudad = (Ciudad)q.getSingleResult();
        }catch(javax.persistence.NoResultException e){
            e.printStackTrace();
            return null;
        }catch(javax.persistence.NonUniqueResultException e){
            e.printStackTrace();
            return null;
        }
        return ciudad;
    }
    
    public boolean editarCiudad(Ciudad c){
        try{
            em.merge(c);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean eliminarCiudad(Ciudad c){
        try{
            em.remove(em.merge(c));
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
