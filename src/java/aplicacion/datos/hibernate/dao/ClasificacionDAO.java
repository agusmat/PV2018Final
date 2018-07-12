/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Clasificaciones;
import java.util.List;

/**
 *
 * @author Tomas Fernandez EdM
 */
public interface ClasificacionDAO {
	List<Clasificaciones> obtenerTodos();
    Clasificaciones consulta(String nombreUsuario, String password);
    void modificar(Clasificaciones unaClasificacion);
    void agregar(Clasificaciones unsClasificacion);
    void eliminar(Clasificaciones unaClasificacion);	
}
