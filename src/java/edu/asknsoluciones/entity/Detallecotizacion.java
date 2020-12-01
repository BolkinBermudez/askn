/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bolkin B
 */
@Entity
@Table(name = "detallecotizacion", catalog = "asknsoluciones2020", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecotizacion.findAll", query = "SELECT d FROM Detallecotizacion d")})
public class Detallecotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private double subtotal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleCotizacion")
    private Integer idDetalleCotizacion;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "IdCotizacion", referencedColumnName = "idCorizacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cotizacion idCotizacion;

    public Detallecotizacion() {
    }

    public Detallecotizacion(Integer idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public Detallecotizacion(Integer idDetalleCotizacion, int cantidad, double subtotal) {
        this.idDetalleCotizacion = idDetalleCotizacion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getIdDetalleCotizacion() {
        return idDetalleCotizacion;
    }

    public void setIdDetalleCotizacion(Integer idDetalleCotizacion) {
        this.idDetalleCotizacion = idDetalleCotizacion;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCotizacion != null ? idDetalleCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecotizacion)) {
            return false;
        }
        Detallecotizacion other = (Detallecotizacion) object;
        if ((this.idDetalleCotizacion == null && other.idDetalleCotizacion != null) || (this.idDetalleCotizacion != null && !this.idDetalleCotizacion.equals(other.idDetalleCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.asknsoluciones.entity.Detallecotizacion[ idDetalleCotizacion=" + idDetalleCotizacion + " ]";
    }
    
}
