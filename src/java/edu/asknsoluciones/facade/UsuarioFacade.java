/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cesar Bernal
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Asknsoluciones2020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario recuperarClave(String correoIn) {

        try {
            Query qt = em.createQuery("SELECT P FROM Usuario p WHERE p.correo = correoIn");
            qt.setParameter("correoIn", correoIn);
            return (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }
    
    @Override
       public Usuario loginUsuario(String correo, String clave){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = correo AND u.clave =:clave");
            q.setParameter("correo", correo);
            q.setParameter("Clave", clave);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
        }
}
       
       
