/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Detalleventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface DetalleventaFacadeLocal {

    void create(Detalleventa detalleventa);

    void edit(Detalleventa detalleventa);

    void remove(Detalleventa detalleventa);

    Detalleventa find(Object id);

    List<Detalleventa> findAll();

    List<Detalleventa> findRange(int[] range);

    int count();
    
}
