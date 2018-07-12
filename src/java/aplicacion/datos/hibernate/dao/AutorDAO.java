/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Autores;
import java.util.List;

/**
 *
 * @author Tomas
 */
public interface AutorDAO {

    List<Autores> obtenerTodos();

    Autores consulta(String nombreUsuario, String password);

    void modificar(Autores unAutor);

    void agregar(Autores unAutor);

    void eliminar(Autores unAutor);
}
