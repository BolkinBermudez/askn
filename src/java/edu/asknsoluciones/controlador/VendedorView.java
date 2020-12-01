/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Cliente;
import edu.asknsoluciones.facade.ClienteFacadeLocal;
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
    /**
     * Creates a new instance of VendedorView
     */
    @PostConstruct
    public void LeerListaCliente(){
        listaClientes.addAll(clienteFacadeLocal.findAll());
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
    
}
