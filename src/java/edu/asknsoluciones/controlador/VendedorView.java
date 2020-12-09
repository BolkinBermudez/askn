/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Cliente;
import edu.asknsoluciones.entity.Detalleventa;
import edu.asknsoluciones.entity.Venta;
import edu.asknsoluciones.facade.ClienteFacadeLocal;
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
@Named(value = "vendedorView")
@ViewScoped
public class VendedorView implements Serializable{

    @EJB
    ClienteFacadeLocal clienteFacadeLocal;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private Cliente cliReg = new Cliente();
    @EJB
    DetalleventaFacadeLocal detalleventaFacadeLocal;
    private ArrayList<Detalleventa> listaDetalleventa = new ArrayList<>();
    private Detalleventa detVenReg = new Detalleventa();
    @EJB
    VentaFacadeLocal ventaFacadeLocal;
    private Venta venReg =new Venta();
    
    private int idCliente = 0;
    private String nombreCliente = "";
    /**
     * Creates a new instance of VendedorView
     */
    @PostConstruct
    public void LeerListaDetalleVenta(){
        listaDetalleventa.addAll(detalleventaFacadeLocal.findAll());
    }
    
    

    public void crearDetalleVenta() {
        String mensajeSw = "";
        try {
            detVenReg.setIdVenta(venReg);
            detalleventaFacadeLocal.create(detVenReg);
            listaDetalleventa.add(detVenReg);
            mensajeSw = "swal('Producto registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El Producto' , ' Ya se encuentra registrado  ', 'error')";
        }
        detVenReg = new Detalleventa();
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void removerDetalleVenta(Detalleventa detVenRem) {
        String mensajeSw = "";
        try {
            detalleventaFacadeLocal.remove(detVenRem);
            listaDetalleventa.remove(detVenRem);
            mensajeSw = "swal('Producto removido' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas removiendo' , ' al Producto  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void cargaVentaEditar(Venta venEditar) {
        this.venReg = venEditar;
    }
    
    public void cargaDetalleVentaEditar(Detalleventa detVenEditar) {
        this.detVenReg = detVenEditar;
    }

    public void editarDetalleVenta() {
        String mensajeSw = "";
        try {
            detalleventaFacadeLocal.edit(detVenReg);
            listaDetalleventa.clear();
            listaDetalleventa.addAll(detalleventaFacadeLocal.findAll());
            mensajeSw = "swal('Detalle de venta modificado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas modificando' , ' al detalle de venta  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }
    
    public int ObtenerIdCliente(){
        String mensajeSw = "";
        try{
            if(cliReg.getNumDocumento() != 0){
                idCliente=cliReg.getIdCliente();
            }else{
                mensajeSw = "swal('El Numero del Cliente' , ' no coinside con los registros  ', 'error')";
            }
        } catch(Exception e){
            mensajeSw = "swal('Problema' , ' Realizando la Consulta  ', 'error')";
        }
        return idCliente;
    }
    
    public String leerCliente(){
        
        while(cliReg.getNumDocumento()== idCliente){
            nombreCliente= cliReg.getNombres();
        }
        return nombreCliente;
    }
    
    //metodo para obtener el nombre del cliente mediante el numero de documento
    public String MostrarNombresCliente(){
        String mensajeSw = "";
        try{
            if(idCliente !=0 ){
                clienteFacadeLocal.find( idCliente);
                nombreCliente= cliReg.getNombres();
            }else{
                mensajeSw = "swal('El id del Cliente' , ' no coinside con los registros  ', 'error')";
            }
            
        } catch(Exception e){
            mensajeSw = "swal('Problema' , ' obteniendo la Consulta  ', 'error')";
        }
        return nombreCliente;
    }
    
    public void crearCliente() {
        String mensajeSw = "";
        try {
            clienteFacadeLocal.create(cliReg);
            listaClientes.add(cliReg);
            mensajeSw = "swal('Cliente registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El Cliente' , ' Ya se encuentra registrado  ', 'error')";
        }
        cliReg = new Cliente();
        PrimeFaces.current().executeScript(mensajeSw);
    }
    public void removerCliente(Cliente cliRem) {
        String mensajeSw = "";
        try {
            clienteFacadeLocal.remove(cliRem);
            listaClientes.remove(cliRem);
            mensajeSw = "swal('Cliente removido' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas removiendo' , ' al cliente  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }
    public void cargaClienteEditar(Cliente cliEditar) {
        this.cliReg = cliEditar;
    }

    public void editarCliente() {
        String mensajeSw = "";
        try {
            clienteFacadeLocal.edit(cliReg);
            listaClientes.clear();
            listaClientes.addAll(clienteFacadeLocal.findAll());
            mensajeSw = "swal('Cliente modificado' , ' con exito. ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas modificando' , ' al cliente.  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }
    public VendedorView() {
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliReg() {
        return cliReg;
    }

    public void setCliReg(Cliente cliReg) {
        this.cliReg = cliReg;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public ArrayList<Detalleventa> getListaDetalleventa() {
        return listaDetalleventa;
    }

    public void setListaDetalleventa(ArrayList<Detalleventa> listaDetalleventa) {
        this.listaDetalleventa = listaDetalleventa;
    }

    public Detalleventa getDetVenReg() {
        return detVenReg;
    }

    public void setDetVenReg(Detalleventa detVenReg) {
        this.detVenReg = detVenReg;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Venta getVenReg() {
        return venReg;
    }

    public void setVenReg(Venta venReg) {
        this.venReg = venReg;
    }
    
}
