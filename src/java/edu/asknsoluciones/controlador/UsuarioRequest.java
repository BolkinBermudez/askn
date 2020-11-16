/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Usuario;
import edu.asknsoluciones.facade.UsuarioFacadeLocal;
import edu.asknsoluciones.utilidades.Email;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Cesar Bernal
 */
@Named(value = "usuarioRequest")
@RequestScoped
public class UsuarioRequest implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private Usuario objUsuario = new Usuario();
    private String correoRecuperar = "";

    public UsuarioRequest() {
    }

    public void crearUsuario() {
        String mensajeSw = "";
        try {
            usuarioFacadeLocal.create(objUsuario);
            mensajeSw = " swal(`usuario registrado`,`con exito`,`success`);";
        } catch (Exception e) {
            mensajeSw = " swal(`El usuario `,`ya se encuentra registrado`,`error`)";
        }
        objUsuario = new Usuario();
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void recuperaClave() {
        Usuario usuRecuperar = new Usuario();
        String mensajeSw = "";
        try {
            usuRecuperar = usuarioFacadeLocal.recuperarClave(correoRecuperar);
            if (usuRecuperar.getNombres() == null) {
                mensajeSw = " swal(`El correo `,`no se encuentra registrado`,`error`)";
            } else {
                Email.sendClaves(usuRecuperar.getCorreo(), 
                                 usuRecuperar.getApellidos() +""+ usuRecuperar.getApellidos(), 
                                 usuRecuperar.getCorreo(), 
                                 usuRecuperar.getClave());
                
               
       
                      
                mensajeSw = " swal(`la clave es enviada `,`a tu correo electronico`,`success`)";

            }

        } catch (Exception e) {
            mensajeSw = " swal(`El correo `,`no se encuentra registrado`,`error`)";

        }
        PrimeFaces.current().executeScript(mensajeSw);
        
    }

 
   
    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public String getCorreoRecuperar() {
        return correoRecuperar;
    }

    public void setCorreoRecuperar(String correoRecuperar) {
        this.correoRecuperar = correoRecuperar;
    }

}
