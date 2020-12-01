/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.controlador;

import edu.asknsoluciones.entity.Producto;
import edu.asknsoluciones.facade.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Bolkin B
 */
@Named(value = "coorBodegaView")
@Dependent
public class CoorBodegaView implements Serializable {

    @EJB
    ProductoFacadeLocal productoFacadeLocal;
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private Producto proReg = new Producto();

    /**
     * Creates a new instance of AdministradorView
     */
    @PostConstruct
    public void leerListaProductos() {
        listaProductos.addAll(productoFacadeLocal.findAll());
    }

    public void crearProducto() {
        String mensajeSw = "";
        try {
            proReg.setFechaIngreso(new Date());
            productoFacadeLocal.create(proReg);
            listaProductos.add(proReg);
            mensajeSw = "swal('Productos registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El Productos' , ' Ya se encuentra registrado  ', 'error')";
        }
        proReg = new Producto();
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void removerProducto(Producto proRem) {
        String mensajeSw = "";
        try {
            productoFacadeLocal.remove(proRem);
            listaProductos.remove(proRem);
            mensajeSw = "swal('Producto removido' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas removiendo' , ' al Producto  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void cargaProductoEditar(Producto proEditar) {
        this.proReg = proEditar;
    }

    public void editarProducto() {
        String mensajeSw = "";
        try {
            productoFacadeLocal.edit(proReg);
            listaProductos.clear();
            listaProductos.addAll(productoFacadeLocal.findAll());
            mensajeSw = "swal('Producto modificado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas modificando' , ' al Producto  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProReg() {
        return proReg;
    }

    public void setProReg(Producto proReg) {
        this.proReg = proReg;
    }

}
