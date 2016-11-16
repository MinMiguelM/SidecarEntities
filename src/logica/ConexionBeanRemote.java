/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Plato;
import entities.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SALABD
 */
@Remote
public interface ConexionBeanRemote {
    
    List<Plato> getPlatos(String busqueda);
    int pago(Usuario user, List<Plato> platos);
}
