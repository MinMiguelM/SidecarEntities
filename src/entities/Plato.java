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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala-a
 */
@Entity
@Table(name = "PLATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findById", query = "SELECT p FROM Plato p WHERE p.id = :id"),
    @NamedQuery(name = "Plato.findByNombre", query = "SELECT p FROM Plato p WHERE p.nombre = :nombre"),
    @NamedQuery(name= "Plato.findSimilar", query = "SELECT p FROM Plato p WHERE p.nombre LIKE :nombre"),
    @NamedQuery(name = "Plato.findByPrecio", query = "SELECT p FROM Plato p WHERE p.precio = :precio"),
    @NamedQuery(name = "Plato.findByDescripcion", query = "SELECT p FROM Plato p WHERE p.descripcion = :descripcion")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PRECIO")
    private BigInteger precio;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinTable(name = "PLATOXRESTAURANTE", joinColumns = {
        @JoinColumn(name = "ID_PLATO", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_RESTAURANTE", referencedColumnName = "ID")})
    @ManyToMany
    private List<Restaurante> restauranteList;
    @JoinColumn(name = "TRANSACCION", referencedColumnName = "NUM_TRANSACCION")
    @ManyToOne
    private Transaccion transaccion;

    public Plato() {
    }

    public Plato(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Restaurante> getRestauranteList() {
        return restauranteList;
    }

    public void setRestauranteList(List<Restaurante> restauranteList) {
        this.restauranteList = restauranteList;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Plato[ id=" + id + " ]";
    }
    
}
