/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Estadoproducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface EstadoproductoFacadeLocal {

    void create(Estadoproducto estadoproducto);

    void edit(Estadoproducto estadoproducto);

    void remove(Estadoproducto estadoproducto);

    Estadoproducto find(Object id);

    List<Estadoproducto> findAll();

    List<Estadoproducto> findRange(int[] range);

    int count();
    
}
