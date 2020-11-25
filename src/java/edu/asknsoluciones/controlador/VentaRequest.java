/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Cliente;
import edu.asknsoluciones.entity.Vendedor;
import edu.asknsoluciones.entity.Venta;
import edu.asknsoluciones.facade.VentaFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bolkin B
 */
@Named(value = "ventaRequest")
@RequestScoped
public class VentaRequest implements Serializable{
    
    @EJB
    VentaFacadeLocal ventaFacadeLocal;
    private Venta venReg = new Venta();
    private Cliente objCliente = new Cliente();
    private Vendedor objVendedor = new Vendedor();
    
    
    
    /**
     * Creates a new instance of VentaRequest
     */
    public VentaRequest() {
    }

    public Venta getVenReg() {
        return venReg;
    }

    public void setVenReg(Venta venReg) {
        this.venReg = venReg;
    }


    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public Vendedor getObjVendedor() {
        return objVendedor;
    }

    public void setObjVendedor(Vendedor objVendedor) {
        this.objVendedor = objVendedor;
    }
    
}
