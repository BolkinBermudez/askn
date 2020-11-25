/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Estadoordenservisio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface EstadoordenservisioFacadeLocal {

    void create(Estadoordenservisio estadoordenservisio);

    void edit(Estadoordenservisio estadoordenservisio);

    void remove(Estadoordenservisio estadoordenservisio);

    Estadoordenservisio find(Object id);

    List<Estadoordenservisio> findAll();

    List<Estadoordenservisio> findRange(int[] range);

    int count();
    
}
