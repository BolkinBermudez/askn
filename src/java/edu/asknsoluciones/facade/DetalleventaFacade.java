/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Detalleventa;
import edu.asknsoluciones.entity.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bolkin B
 */
@Stateless
public class DetalleventaFacade extends AbstractFacade<Detalleventa> implements DetalleventaFacadeLocal {

    @PersistenceContext(unitName = "Asknsoluciones2020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleventaFacade() {
        super(Detalleventa.class);
    }

    @Override
    public void remove(Producto proRem) {
        try {
            //aqui  qry para  eliminar  producto de  detalle  venta
            Query q = em.createQuery("SELECT p FROM detalleventa  WHERE p.idProducto = proRem");
            
            
        } catch (Exception e) {
            //debe  retornar algo
            return ;
        }
    }
    
}
