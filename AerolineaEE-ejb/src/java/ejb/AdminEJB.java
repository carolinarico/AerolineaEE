/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import entidad.AdminA;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author EST
 */
@Stateless
@LocalBean
public class AdminEJB {
    
    @PersistenceContext(unitName="AerolineaEE-ejbPU")
    private EntityManager em;
    
    
   public List <AdminA> obtenerAdministrador(){
       List <AdminA> admins = new ArrayList<AdminA>();
       Query q = em.createNamedQuery("AdminA.findAll");
       try{
           admins = q.getResultList();
       }catch(javax.persistence.NoResultException e){
           return null;
       }
       return admins;
   }

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
