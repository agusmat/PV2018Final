/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;


import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface UsuarioDAO {
    List<Usuarios> obtenerTodos();
    Usuarios consulta(String nombreUsuario, String password);
    void modificar(Usuarios usuario);
    void agregar(Usuarios usuario);
    void eliminar(Usuarios usuario);
}