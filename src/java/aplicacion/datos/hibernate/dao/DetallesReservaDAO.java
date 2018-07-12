/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.DetallesReservas;
import java.util.List;

/**
 *
 * @author Tomas
 */
public interface DetallesReservaDAO {

    List<DetallesReservas> obtenerTodos();

    DetallesReservas consulta(String nombreUsuario, String password);

    void modificar(DetallesReservas unDetallesReservas);

    void agregar(DetallesReservas unDetallesReservas);

    void eliminar(DetallesReservas unDetallesReservas);
}
