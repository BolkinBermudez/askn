/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Tecnico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface TecnicoFacadeLocal {

    void create(Tecnico tecnico);

    void edit(Tecnico tecnico);

    void remove(Tecnico tecnico);

    Tecnico find(Object id);

    List<Tecnico> findAll();

    List<Tecnico> findRange(int[] range);

    int count();
    
}
