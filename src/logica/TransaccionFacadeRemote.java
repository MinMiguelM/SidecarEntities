/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Plato;
import entities.Transaccion;
import entities.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SALABD
 */
@Remote
public interface TransaccionFacadeRemote {

    void create(Transaccion transaccion);

    void edit(Transaccion transaccion);

    void remove(Transaccion transaccion);

    Transaccion find(Object id);

    List<Transaccion> findAll();

    List<Transaccion> findRange(int[] range);

    int count();
    
    List<Transaccion> getTransaccionByUsuario(String cedula);
    
    int pago(Usuario user, List<Plato> platos);

    List<Transaccion> getTransacciones(String date);
}
