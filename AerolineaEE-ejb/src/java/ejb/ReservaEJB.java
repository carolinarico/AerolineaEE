/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Reserva;
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
public class ReservaEJB {

    @PersistenceContext(unitName = "AerolineaEE-ejbPU")
    private EntityManager em;

    public boolean crearReserva(Reserva r) {
        try {
            em.persist(r);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Reserva> obtenerReservas() {
        List<Reserva> reservas = new ArrayList<Reserva>();
        Query q = em.createNamedQuery("Reserva.findAll");
        try {
            reservas = q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return reservas;
    }

    public boolean editarReserva(Reserva r) {
        try {
            em.merge(r);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean eliminarReserva(Reserva r) {
        try {
            em.remove(em.merge(r));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List <Reserva> obtenerReservaByCliente(int idcliente) {
        List <Reserva> reserva = new ArrayList<Reserva>();
        Query q = em.createQuery("SELECT r FROM Reserva r WHERE r.idcliente.idcliente = :idcliente");
        q.setParameter("idcliente", new Integer(idcliente));
        try {
            reserva = q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            e.printStackTrace();
            return null;
        }
        return reserva;
    }

    public Reserva reservaByClienteYViaje(int idcliente, int idvuelo) {
        Reserva reserva = new Reserva();
        List<Reserva> r = new ArrayList<Reserva>();
        r = this.obtenerReservaByCliente(idcliente);
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getIdvuelo().getIdvuelo() == idvuelo) {
                reserva = r.get(i);
                break;
            }
        }
        return reserva;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
