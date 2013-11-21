/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Cliente;
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
public class ClienteEJB {
    
    @PersistenceContext(unitName="AerolineaEE-ejbPU")
    private EntityManager em;
    
    public boolean crearCliente(Cliente cl){        
        try{
            em.persist(cl);
        }catch(Exception e){
           e.printStackTrace();
            return false;
        }
    return true;
    }
    
    public List <Cliente> obtenerClientes(){
        List <Cliente> clientes = new ArrayList<Cliente>();
        Query q = em.createNamedQuery("Cliente.findAll");
        try{
            clientes = q.getResultList();
        }catch(javax.persistence.NoResultException e){
            return null;
        }
        return clientes;
    }
    
    public boolean editarCliente(Cliente cl){
        try{
            em.merge(cl);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean eliminarCliente(Cliente cl){
        try{
            em.remove(em.merge(cl));
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
