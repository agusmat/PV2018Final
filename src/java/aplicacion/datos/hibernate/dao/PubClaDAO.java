/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.PubCla;
import java.util.List;

/**
 *
 * @author Agustin
 */
public interface PubClaDAO {
    List<PubCla> obtenerTodos();
    PubCla consulta(String nombreUsuario, String password);
    void modificar(PubCla usuario);
    void agregar(PubCla usuario);
    void eliminar(PubCla usuario);
}
