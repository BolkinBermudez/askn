/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bolkin B
 */
@Entity
@Table(name = "ordenservisio", catalog = "asknsoluciones2020", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenservisio.findAll", query = "SELECT o FROM Ordenservisio o")})
public class Ordenservisio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdenServisio")
    private Integer idOrdenServisio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProducto")
    private int codProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcionFalla")
    private String descripcionFalla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fechaProceso")
    @Temporal(TemporalType.DATE)
    private Date fechaProceso;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 60)
    @Column(name = "marca")
    private String marca;
    @JoinColumn(name = "IdTecnico", referencedColumnName = "idTecnico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tecnico idTecnico;
    @JoinColumn(name = "idEstadoOS", referencedColumnName = "IdEstadoOS")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estadoordenservisio idEstadoOS;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;

    public Ordenservisio() {
    }

    public Ordenservisio(Integer idOrdenServisio) {
        this.idOrdenServisio = idOrdenServisio;
    }

    public Ordenservisio(Integer idOrdenServisio, int codProducto, String descripcionFalla, Date fechaIngreso) {
        this.idOrdenServisio = idOrdenServisio;
        this.codProducto = codProducto;
        this.descripcionFalla = descripcionFalla;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdOrdenServisio() {
        return idOrdenServisio;
    }

    public void setIdOrdenServisio(Integer idOrdenServisio) {
        this.idOrdenServisio = idOrdenServisio;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcionFalla() {
        return descripcionFalla;
    }

    public void setDescripcionFalla(String descripcionFalla) {
        this.descripcionFalla = descripcionFalla;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Tecnico getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Estadoordenservisio getIdEstadoOS() {
        return idEstadoOS;
    }

    public void setIdEstadoOS(Estadoordenservisio idEstadoOS) {
        this.idEstadoOS = idEstadoOS;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenServisio != null ? idOrdenServisio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenservisio)) {
            return false;
        }
        Ordenservisio other = (Ordenservisio) object;
        if ((this.idOrdenServisio == null && other.idOrdenServisio != null) || (this.idOrdenServisio != null && !this.idOrdenServisio.equals(other.idOrdenServisio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.asknsoluciones.entity.Ordenservisio[ idOrdenServisio=" + idOrdenServisio + " ]";
    }
    
}
