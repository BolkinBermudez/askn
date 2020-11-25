/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asknsoluciones.facade;

import edu.asknsoluciones.entity.Coordinadorbodega;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bolkin B
 */
@Local
public interface CoordinadorbodegaFacadeLocal {

    void create(Coordinadorbodega coordinadorbodega);

    void edit(Coordinadorbodega coordinadorbodega);

    void remove(Coordinadorbodega coordinadorbodega);

    Coordinadorbodega find(Object id);

    List<Coordinadorbodega> findAll();

    List<Coordinadorbodega> findRange(int[] range);

    int count();
    
}
