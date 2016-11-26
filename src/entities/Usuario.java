/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SALABD
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNumDocumento", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.numDocumento = :numDocumento"),
    @NamedQuery(name = "Usuario.findByTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByUsuariomispagos", query = "SELECT u FROM Usuario u WHERE u.usuariomispagos = :usuariomispagos"),
    @NamedQuery(name = "Usuario.findByPasswordmispagos", query = "SELECT u FROM Usuario u WHERE u.passwordmispagos = :passwordmispagos"),
    @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Size(max = 250)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 250)
    @Column(name = "USUARIOMISPAGOS")
    private String usuariomispagos;
    @Size(max = 250)
    @Column(name = "PASSWORDMISPAGOS")
    private String passwordmispagos;
    @Size(max = 250)
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;
    @OneToMany(mappedBy = "usuario")
    private List<Transaccion> transaccionList;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(BigInteger numDocumento, String tipoDocumento) {
        this.usuarioPK = new UsuarioPK(numDocumento, tipoDocumento);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuariomispagos() {
        return usuariomispagos;
    }

    public void setUsuariomispagos(String usuariomispagos) {
        this.usuariomispagos = usuariomispagos;
    }

    public String getPasswordmispagos() {
        return passwordmispagos;
    }

    public void setPasswordmispagos(String passwordmispagos) {
        this.passwordmispagos = passwordmispagos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
