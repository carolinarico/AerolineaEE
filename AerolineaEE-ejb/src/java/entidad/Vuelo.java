/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EST
 */
@Entity
@Table(name = "VUELO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByIdvuelo", query = "SELECT v FROM Vuelo v WHERE v.idvuelo = :idvuelo"),
    @NamedQuery(name = "Vuelo.findByCodigo", query = "SELECT v FROM Vuelo v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Vuelo.findByFechav", query = "SELECT v FROM Vuelo v WHERE v.fechav = :fechav")})
public class Vuelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVUELO")
    private Short idvuelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FECHAV")
    private String fechav;
    @JoinColumn(name = "DESTINO", referencedColumnName = "IDCIUDAD")
    @ManyToOne(optional = false)
    private Ciudad destino;
    @JoinColumn(name = "ORIGEN", referencedColumnName = "IDCIUDAD")
    @ManyToOne(optional = false)
    private Ciudad origen;

    public Vuelo() {
    }

    public Vuelo(Short idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Vuelo(Short idvuelo, String codigo, String fechav) {
        this.idvuelo = idvuelo;
        this.codigo = codigo;
        this.fechav = fechav;
    }

    public Short getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Short idvuelo) {
        this.idvuelo = idvuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechav() {
        return fechav;
    }

    public void setFechav(String fechav) {
        this.fechav = fechav;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvuelo != null ? idvuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idvuelo == null && other.idvuelo != null) || (this.idvuelo != null && !this.idvuelo.equals(other.idvuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Vuelo[ idvuelo=" + idvuelo + " ]";
    }
    
    public void setFechav(Date fechav) {
		DateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");
		this.fechav = (formatFecha.format(fechav).toString());
	}
}
