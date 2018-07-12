/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.DetallesPrestamoDAO;
import aplicacion.datos.hibernate.dao.implementacion.DetallesPrestamoDAOImp;
import aplicacion.datos.hibernate.mapeos.DetallesPrestamos;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tomas Fernandez EdM
 */
@ManagedBean
@ViewScoped
public class DetallesPrestamoBean {

	/**
	 * Creates a new instance of DetallesPrestamoBean
	 */
	public DetallesPrestamoBean() {
	}

	public void agregarDetallesPrestamo(DetallesPrestamos unDetallesPrestamo) {
		DetallesPrestamoDAO detallesPrestamoDAO = new DetallesPrestamoDAOImp();
		detallesPrestamoDAO.agregar(unDetallesPrestamo);
	}

	public List<DetallesPrestamos> listarDetallesPrestamos() {
		DetallesPrestamoDAO detallesPrestamoDAO = new DetallesPrestamoDAOImp();
		return detallesPrestamoDAO.obtenerTodos();
	}

	public void modificarDetallesPrestamo(DetallesPrestamos unDetallesPrestamo) {
		DetallesPrestamoDAO detallesPrestamoDAO = new DetallesPrestamoDAOImp();
		detallesPrestamoDAO.modificar(unDetallesPrestamo);
	}
}
