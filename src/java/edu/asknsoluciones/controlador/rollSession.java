/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Rol;
import edu.asknsoluciones.facade.RolFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Cesar Bernal
 */
@Named(value = "rollSession")
@SessionScoped
public class rollSession implements Serializable {

  @EJB
    RolFacadeLocal rolFacadeLocal;
  
    private ArrayList<Rol> listaRoll = new ArrayList<>();
    private Rol usRol = new Rol();
    
    
    public rollSession() {
    }
    
    
    
     @PostConstruct
    public void Roll() {
        listaRoll.addAll(rolFacadeLocal.findAll());
    }

      public void crearRoll() {
        String mensajeSw = "";
        try {
            usRol.setDescripcion(new String());
            rolFacadeLocal.create(usRol);
            listaRoll.add(usRol);
            mensajeSw = "swal('Usuario registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El usuario' , ' Ya se encuentra registrado  ', 'error')";
        }
        usRol = new Rol();
        PrimeFaces.current().executeScript(mensajeSw);
    }
    
    public ArrayList<Rol> getListaRoll() {
        return listaRoll;
    }

    public void setListaRoll(ArrayList<Rol> listaRoll) {
        this.listaRoll = listaRoll;
    }

    public Rol getUsRol() {
        return usRol;
    }

    public void setUsRol(Rol usRol) {
        this.usRol = usRol;
    }

 
}
