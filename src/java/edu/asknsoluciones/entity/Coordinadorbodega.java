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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bolkin B
 */
@Entity
@Table(name = "coordinadorbodega", catalog = "asknsoluciones2020", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinadorbodega.findAll", query = "SELECT c FROM Coordinadorbodega c")})
public class Coordinadorbodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCoordinadorBodega")
    private Integer idCoordinadorBodega;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public Coordinadorbodega() {
    }

    public Coordinadorbodega(Integer idCoordinadorBodega) {
        this.idCoordinadorBodega = idCoordinadorBodega;
    }

    public Integer getIdCoordinadorBodega() {
        return idCoordinadorBodega;
    }

    public void setIdCoordinadorBodega(Integer idCoordinadorBodega) {
        this.idCoordinadorBodega = idCoordinadorBodega;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoordinadorBodega != null ? idCoordinadorBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinadorbodega)) {
            return false;
        }
        Coordinadorbodega other = (Coordinadorbodega) object;
        if ((this.idCoordinadorBodega == null && other.idCoordinadorBodega != null) || (this.idCoordinadorBodega != null && !this.idCoordinadorBodega.equals(other.idCoordinadorBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.asknsoluciones.entity.Coordinadorbodega[ idCoordinadorBodega=" + idCoordinadorBodega + " ]";
    }
    
}
