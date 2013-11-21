/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EST
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva"),
    @NamedQuery(name = "Reserva.findByFechar", query = "SELECT r FROM Reserva r WHERE r.fechar = :fechar")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "IDRESERVA")
    private Short idreserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAR")
    @Temporal(TemporalType.DATE)
    private Date fechar;
    @JoinColumn(name = "IDVUELO", referencedColumnName = "IDVUELO")
    @ManyToOne(optional = false)
    private Vuelo idvuelo;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Reserva() {
    }

    public Reserva(Short idreserva) {
        this.idreserva = idreserva;
    }

    public Reserva(Short idreserva, Date fechar) {
        this.idreserva = idreserva;
        this.fechar = fechar;
    }

    public Short getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Short idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechar() {
        return fechar;
    }

    public void setFechar(Date fechar) {
        this.fechar = fechar;
    }

    public Vuelo getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Vuelo idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
