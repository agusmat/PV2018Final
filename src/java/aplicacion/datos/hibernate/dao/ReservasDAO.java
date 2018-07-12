/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Reservas;
import java.util.List;

/**
 *
 * @author Tiago
 */
public interface ReservasDAO {
    List<Reservas> obtenerTodos();
    Perfiles consulta(String nombreUsuario, String password);
    void modificar(Reservas usuario);
    void agregar(Reservas usuario);
    void eliminar(Reservas usuario);

}
