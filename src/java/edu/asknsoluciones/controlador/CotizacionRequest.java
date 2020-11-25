/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.facade.CotizacionFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bolkin B
 */
@Named(value = "cotizacionRequest")
@RequestScoped
public class CotizacionRequest implements Serializable{

    @EJB
    CotizacionFacadeLocal cotizacionFacadeLocal;
    
    /**
     * Creates a new instance of CotizacionRequest
     */
    public CotizacionRequest() {
    }
    
}
