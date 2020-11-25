/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Ordenservisio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface OrdenservisioFacadeLocal {

    void create(Ordenservisio ordenservisio);

    void edit(Ordenservisio ordenservisio);

    void remove(Ordenservisio ordenservisio);

    Ordenservisio find(Object id);

    List<Ordenservisio> findAll();

    List<Ordenservisio> findRange(int[] range);

    int count();
    
}
