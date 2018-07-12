/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Prestamos;
import java.util.List;

/**
 *
 * @author Tomas
 */
public interface PrestamoDAO {
    List<Prestamos> obtenerTodos();
    Prestamos consulta(String nombreUsuario, String password);
    void modificar(Prestamos unPrestamo);
    void agregar(Prestamos unPrestamo);
    void eliminar(Prestamos unPrestamo);
}
