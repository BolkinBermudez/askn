/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Formapago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface FormapagoFacadeLocal {

    void create(Formapago formapago);

    void edit(Formapago formapago);

    void remove(Formapago formapago);

    Formapago find(Object id);

    List<Formapago> findAll();

    List<Formapago> findRange(int[] range);

    int count();
    
}
