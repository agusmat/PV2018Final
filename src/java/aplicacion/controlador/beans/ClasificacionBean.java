/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.ClasificacionDAO;
import aplicacion.datos.hibernate.dao.implementacion.ClasificacionDAOImp;
import aplicacion.datos.hibernate.mapeos.Clasificaciones;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tomas Fernandez EdM
 */
@ManagedBean
@ViewScoped
public class ClasificacionBean {

	/**
	 * Creates a new instance of ClasificacionBean
	 */
	public ClasificacionBean() {
	}

	public void agregarClasificacion(Clasificaciones unaClasificacion) {
		ClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
		clasificacionDAO.agregar(unaClasificacion);
	}

	public List<Clasificaciones> listarClasificaciones() {
		ClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
		return clasificacionDAO.obtenerTodos();
	}

	public void modificarClasificacion(Clasificaciones unaClasificacion) {
		ClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
		clasificacionDAO.modificar(unaClasificacion);
	}
}
