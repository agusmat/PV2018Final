/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Publicaciones;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface PublicacionesDAO {
    List<Publicaciones> obtenerTodos();
    Publicaciones consulta(String nombreUsuario, String password);
    void modificar(Publicaciones usuario);
    void agregar(Publicaciones usuario);
    void eliminar(Publicaciones usuario);
}
