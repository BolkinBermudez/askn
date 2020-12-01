/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario recuperarClave(String correoRecuperar);
    
    public Usuario loginUsuario(String correo, String clave);
    
}
