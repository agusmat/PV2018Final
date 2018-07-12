/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.DetallesPrestamos;
import java.util.List;

/**
 *
 * @author Tomas Fernandez EdM
 */
public interface DetallesPrestamoDAO {

	List<DetallesPrestamos> obtenerTodos();

	DetallesPrestamos consulta(String nombreUsuario, String password);

	void modificar(DetallesPrestamos unDetallesPrestamo);

	void agregar(DetallesPrestamos unDetallesPrestamo);

	void eliminar(DetallesPrestamos unDetallesPrestamo);
}
