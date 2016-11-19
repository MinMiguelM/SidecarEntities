/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala-a
 */
@Entity
@Table(name = "TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByNumTransaccion", query = "SELECT t FROM Transaccion t WHERE t.numTransaccion = :numTransaccion"),
    @NamedQuery(name = "Transaccion.findByFecha", query = "SELECT t FROM Transaccion t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Transaccion.findByValor", query = "SELECT t FROM Transaccion t WHERE t.valor = :valor")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_TRANSACCION")
    private BigDecimal numTransaccion;
    @Size(max = 20)
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "VALOR")
    private BigInteger valor;
    @ManyToMany(mappedBy = "transaccionList")
    private List<Plato> platoList;
    @JoinColumn(name = "CEDULA_USUARIO", referencedColumnName = "CEDULA")
    @ManyToOne
    private Usuario cedulaUsuario;

    public Transaccion() {
    }

    public Transaccion(BigDecimal numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public BigDecimal getNumTransaccion() {
        return numTransaccion;
    }

    public void setNumTransaccion(BigDecimal numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<Plato> getPlatoList() {
        return platoList;
    }

    public void setPlatoList(List<Plato> platoList) {
        this.platoList = platoList;
    }

    public Usuario getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(Usuario cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTransaccion != null ? numTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.numTransaccion == null && other.numTransaccion != null) || (this.numTransaccion != null && !this.numTransaccion.equals(other.numTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transaccion[ numTransaccion=" + numTransaccion + " ]";
    }
    
}
