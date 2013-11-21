/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EST
 */
@Entity
@Table(name = "ADMIN_A")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminA.findAll", query = "SELECT a FROM AdminA a"),
    @NamedQuery(name = "AdminA.findByIdadminA", query = "SELECT a FROM AdminA a WHERE a.idadminA = :idadminA"),
    @NamedQuery(name = "AdminA.findByLogin", query = "SELECT a FROM AdminA a WHERE a.login = :login"),
    @NamedQuery(name = "AdminA.findByPassword", query = "SELECT a FROM AdminA a WHERE a.password = :password")})
public class AdminA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDADMIN_A")
    private Short idadminA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;

    public AdminA() {
    }

    public AdminA(Short idadminA) {
        this.idadminA = idadminA;
    }

    public AdminA(Short idadminA, String login, String password) {
        this.idadminA = idadminA;
        this.login = login;
        this.password = password;
    }

    public Short getIdadminA() {
        return idadminA;
    }

    public void setIdadminA(Short idadminA) {
        this.idadminA = idadminA;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadminA != null ? idadminA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminA)) {
            return false;
        }
        AdminA other = (AdminA) object;
        if ((this.idadminA == null && other.idadminA != null) || (this.idadminA != null && !this.idadminA.equals(other.idadminA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.AdminA[ idadminA=" + idadminA + " ]";
    }
    
}
