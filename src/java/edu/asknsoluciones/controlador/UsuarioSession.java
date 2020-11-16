package edu.asknsoluciones.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.asknsoluciones.entity.Usuario;
import edu.asknsoluciones.facade.UsuarioFacade;
import edu.asknsoluciones.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Cesar Bernal
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String correoIn = "";
    private String claveIn = "";
    private Usuario usuLogin = new Usuario();

    public UsuarioSession() {
        String mensajeSw = "";
        try {
            usuLogin = usuarioFacadeLocal.loginUsuario(correoIn, claveIn);
            
            if(usuLogin.getId() == null){
             mensajeSw = " swal(`El usuario  `,`no se encuentra registrado`,`error`)";
            }else{
             mensajeSw = " swal(`El usuario  `,`si se encuentra registrado`,`success`)";
            }
      
        } catch (Exception e) {
            mensajeSw = " swal(`El usuario  `,`no se encuentra registrado`,`error`)";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void inicioSeccion() {
     String mensajeSw = "";
        try {
            usuLogin = usuarioFacadeLocal.loginUsuario(correoIn, claveIn);

            if (usuLogin.getId() == null) {
                mensajeSw = "swal('El usuario' , ' No se encuentra registrado  ', 'error')";
            } else {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("miperfil/Template.xhtml");
            }

        } catch (Exception e) {
            mensajeSw = "swal('El usuario' , ' No se encuentra registrado  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);

    }

    public String getCorreoIn() {
        return correoIn;
    }

    public void setCorreoIn(String correoIn) {
        this.correoIn = correoIn;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }

}
