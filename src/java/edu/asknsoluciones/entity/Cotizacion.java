/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bolkin B
 */
@Entity
@Table(name = "cotizacion", catalog = "asknsoluciones2020", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCorizacion")
    private Integer idCorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @OneToMany(mappedBy = "idCotizacion", fetch = FetchType.LAZY)
    private Collection<Detalleventa> detalleventaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotizacion", fetch = FetchType.LAZY)
    private Collection<Detallecotizacion> detallecotizacionCollection;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "idVendedor", referencedColumnName = "IdVendedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vendedor idVendedor;

    public Cotizacion() {
    }

    public Cotizacion(Integer idCorizacion) {
        this.idCorizacion = idCorizacion;
    }

    public Cotizacion(Integer idCorizacion, Date fechaSolicitud, Date fechaVencimiento, double total) {
        this.idCorizacion = idCorizacion;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaVencimiento = fechaVencimiento;
        this.total = total;
    }

    public Integer getIdCorizacion() {
        return idCorizacion;
    }

    public void setIdCorizacion(Integer idCorizacion) {
        this.idCorizacion = idCorizacion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Detalleventa> getDetalleventaCollection() {
        return detalleventaCollection;
    }

    public void setDetalleventaCollection(Collection<Detalleventa> detalleventaCollection) {
        this.detalleventaCollection = detalleventaCollection;
    }

    @XmlTransient
    public Collection<Detallecotizacion> getDetallecotizacionCollection() {
        return detallecotizacionCollection;
    }

    public void setDetallecotizacionCollection(Collection<Detallecotizacion> detallecotizacionCollection) {
        this.detallecotizacionCollection = detallecotizacionCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorizacion != null ? idCorizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCorizacion == null && other.idCorizacion != null) || (this.idCorizacion != null && !this.idCorizacion.equals(other.idCorizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.asknsoluciones.entity.Cotizacion[ idCorizacion=" + idCorizacion + " ]";
    }
    
}
