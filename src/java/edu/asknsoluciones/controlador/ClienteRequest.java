/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Cliente;
import edu.asknsoluciones.facade.ClienteFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Bolkin B
 */
@Named(value = "clienteRequest")
@RequestScoped
public class ClienteRequest implements Serializable{
    
    @EJB
    ClienteFacadeLocal clienteFacadeLocal;

     private Cliente objCliente = new Cliente();
    

    

    public void crearUsuario() {
        String mensajeSw = "";
        try {
            clienteFacadeLocal.create(objCliente);
            mensajeSw = " swal(`Cliente registrado`,`con exito`,`success`);";
        } catch (Exception e) {
            mensajeSw = " swal(`El cliente `,`ya se encuentra registrado`,`error`)";
        }
        objCliente = new Cliente();
        PrimeFaces.current().executeScript(mensajeSw);
    }
    /**
     * Creates a new instance of ClienteRequest
     */
    public ClienteRequest() {
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }
    
}
