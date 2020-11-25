/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Estadoventa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface EstadoventaFacadeLocal {

    void create(Estadoventa estadoventa);

    void edit(Estadoventa estadoventa);

    void remove(Estadoventa estadoventa);

    Estadoventa find(Object id);

    List<Estadoventa> findAll();

    List<Estadoventa> findRange(int[] range);

    int count();
    
}
