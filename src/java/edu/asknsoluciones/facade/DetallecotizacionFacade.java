/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Detallecotizacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bolkin B
 */
@Stateless
public class DetallecotizacionFacade extends AbstractFacade<Detallecotizacion> implements DetallecotizacionFacadeLocal {

    @PersistenceContext(unitName = "Asknsoluciones2020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallecotizacionFacade() {
        super(Detallecotizacion.class);
    }
    
}
