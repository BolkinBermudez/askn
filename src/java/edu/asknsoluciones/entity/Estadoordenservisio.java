/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bolkin B
 */
@Entity
@Table(name = "estadoordenservisio", catalog = "asknsoluciones2020", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoordenservisio.findAll", query = "SELECT e FROM Estadoordenservisio e")})
public class Estadoordenservisio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEstadoOS")
    private Integer idEstadoOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estadoOS")
    private String estadoOS;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoOS", fetch = FetchType.LAZY)
    private Collection<Ordenservisio> ordenservisioCollection;

    public Estadoordenservisio() {
    }

    public Estadoordenservisio(Integer idEstadoOS) {
        this.idEstadoOS = idEstadoOS;
    }

    public Estadoordenservisio(Integer idEstadoOS, String estadoOS) {
        this.idEstadoOS = idEstadoOS;
        this.estadoOS = estadoOS;
    }

    public Integer getIdEstadoOS() {
        return idEstadoOS;
    }

    public void setIdEstadoOS(Integer idEstadoOS) {
        this.idEstadoOS = idEstadoOS;
    }

    public String getEstadoOS() {
        return estadoOS;
    }

    public void setEstadoOS(String estadoOS) {
        this.estadoOS = estadoOS;
    }

    @XmlTransient
    public Collection<Ordenservisio> getOrdenservisioCollection() {
        return ordenservisioCollection;
    }

    public void setOrdenservisioCollection(Collection<Ordenservisio> ordenservisioCollection) {
        this.ordenservisioCollection = ordenservisioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOS != null ? idEstadoOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoordenservisio)) {
            return false;
        }
        Estadoordenservisio other = (Estadoordenservisio) object;
        if ((this.idEstadoOS == null && other.idEstadoOS != null) || (this.idEstadoOS != null && !this.idEstadoOS.equals(other.idEstadoOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.asknsoluciones.entity.Estadoordenservisio[ idEstadoOS=" + idEstadoOS + " ]";
    }
    
}
