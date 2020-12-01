/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Producto;
import edu.asknsoluciones.entity.Venta;
import edu.asknsoluciones.facade.DetalleventaFacadeLocal;
import edu.asknsoluciones.facade.VentaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Bolkin B
 */
@Named(value = "ventaView")
@ViewScoped
public class VentaView implements Serializable{

     @EJB
    VentaFacadeLocal ventaFacadeLocal;
    DetalleventaFacadeLocal detalleventaFacadeLocal;
    private ArrayList<Venta> listaUsuarios = new ArrayList<>();
    private Venta venReg = new Venta();

    /**
     * Creates a new instance of AdministradorView
     */
    @PostConstruct
    public void leerListaUsuarios() {
        listaUsuarios.addAll(ventaFacadeLocal.findAll());
    }

    public void crearUsuario() {
        String mensajeSw = "";
        try {
            venReg.setFecha(new Date());
            ventaFacadeLocal.create(venReg);
            listaUsuarios.add(venReg);
            mensajeSw = "swal('Usuario registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El usuario' , ' Ya se encuentra registrado  ', 'error')";
        }
        venReg = new Venta();
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void removerProducto(Producto proRem) {
        String mensajeSw = "";
        try {
            detalleventaFacadeLocal.remove(proRem);
            listaUsuarios.remove(proRem);
            mensajeSw = "swal('Producto removido' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas removiendo' , ' al Producto  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    

    
    /**
     * Creates a new instance of VentaView
     */
    public VentaView() {
    }

    public ArrayList<Venta> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Venta> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Venta getVenReg() {
        return venReg;
    }

    public void setVenReg(Venta venReg) {
        this.venReg = venReg;
    }
    
}
