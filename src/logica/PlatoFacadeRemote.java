/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Plato;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SALABD
 */
@Remote
public interface PlatoFacadeRemote {

    void create(Plato plato);

    void edit(Plato plato);

    void remove(Plato plato);

    Plato find(Object id);

    List<Plato> findAll();

    List<Plato> findRange(int[] range);

    int count();
    
    List<Plato> getPlatos(String busqueda);
    
}
