/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Restaurante;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SALABD
 */
@Remote
public interface RestauranteFacadeRemote {

    void create(Restaurante restaurante);

    void edit(Restaurante restaurante);

    void remove(Restaurante restaurante);

    Restaurante find(Object id);

    List<Restaurante> findAll();

    List<Restaurante> findRange(int[] range);

    int count();
    
    List<Restaurante> getRestaurantes(String busqueda);

    Restaurante getByName(String busq);
}
