/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Perfiles;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface PerfilDAO {
    List<Perfiles> obtenerTodos();
    Perfiles consulta(String nombreUsuario, String password);
    void modificar(Perfiles usuario);
    void agregar(Perfiles usuario);
    void eliminar(Perfiles usuario);
}
