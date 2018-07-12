/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.PubAut;
import java.util.List;

/**
 *
 * @author Tomas
 */
public interface PubAutDAO {
    List<PubAut> obtenerTodos();
    Perfiles consulta(String nombreUsuario, String password);
    void modificar(PubAut unPubAut);
    void agregar(PubAut unPubAut);
    void eliminar(PubAut unPubAut);
}
