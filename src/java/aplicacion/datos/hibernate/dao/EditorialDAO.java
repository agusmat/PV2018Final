/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Editoriales;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface EditorialDAO {
    List<Editoriales> obtenerTodos();
    Editoriales consulta(String nombreUsuario, String password);
    void modificar(Editoriales unaEditorial);
    void agregar(Editoriales unaEditorial);
    void eliminar(Editoriales unaEditorial);
}
