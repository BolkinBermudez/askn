/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Cliente;
import edu.asknsoluciones.entity.Estadoventa;
import edu.asknsoluciones.entity.Producto;
import edu.asknsoluciones.entity.Vendedor;
import edu.asknsoluciones.entity.Venta;
import edu.asknsoluciones.facade.ClienteFacadeLocal;
import edu.asknsoluciones.facade.DetalleventaFacadeLocal;
import edu.asknsoluciones.facade.UsuarioFacadeLocal;
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
public class VentaView implements Serializable {

    @EJB
    VentaFacadeLocal ventaFacadeLocal;
    @EJB
    DetalleventaFacadeLocal detalleventaFacadeLocal;
    @EJB
    ClienteFacadeLocal clienteFacadeLocal;
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    private ArrayList<Venta> listaUsuarios = new ArrayList<>();
    private Venta venReg = new Venta();
    private Cliente objCliente = new Cliente();
    private Vendedor objVendedor = new Vendedor();
    private Estadoventa objEstadoVenta = new Estadoventa();
    private int numDocCli = 0;

    /**
     * Creates a new instance of AdministradorView
     */
    @PostConstruct
    public void leerListaUsuarios() {
        listaUsuarios.addAll(ventaFacadeLocal.findAll());
    }

    
    

    public void crearNuevaVenta() {
        String mensajeSw = "";
        try {
            venReg.setFecha(new Date());
            venReg.setIdCliente(objCliente);
            venReg.setIdVendedor(objVendedor);
            venReg.setIdEstado(objEstadoVenta);
            ventaFacadeLocal.create(venReg);
            mensajeSw = "swal('Estado de la venta ' , ' se actualizo a venta en proceso. ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('la venta' , ' Yno se pudo registrar  ', 'error')";
        }

        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void recuperarIdCliente() {

        Cliente cliRecuperar = new Cliente();
        String mensajeSw = "";
        try {
            cliRecuperar = clienteFacadeLocal.BuscarIdCliente(numDocCli);
            if (cliRecuperar.getNombres() == null) {
                mensajeSw = " swal(`El cliente `,`no se encuentra registrado`,`error`)";
            } else {

                objCliente = cliRecuperar;

                mensajeSw = " swal(` Datos del Cliente `,`Recuperados con exito`,`success`)";

            }

        } catch (Exception e) {
            mensajeSw = " swal(`El cliente`,`no se encuentra registrado`,`error`)";

        }
        PrimeFaces.current().executeScript(mensajeSw);

    }

    public void crearCliente() {
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

    public Estadoventa getObjEstadoVenta() {
        return objEstadoVenta;
    }

    public void setObjEstadoVenta(Estadoventa objEstadoVenta) {
        this.objEstadoVenta = objEstadoVenta;
    }

    public int getNumDocCli() {
        return numDocCli;
    }

    public void setNumDocCli(int numDocCli) {
        this.numDocCli = numDocCli;
    }

}
