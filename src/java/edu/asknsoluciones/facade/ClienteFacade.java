/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bolkin B
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "Asknsoluciones2020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente BuscarIdCliente(int numDocCli) {
        try {
            Query qt = em.createQuery("SELECT * FROM `cliente` WHERE `numDocumento` =:numDocCli");
            qt.setParameter("numDocumento", numDocCli);
            return (Cliente) qt.getSingleResult();
        } catch (Exception e) {
            return new Cliente();
        }

    }
}
