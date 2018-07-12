/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PrestamoDAO;
import aplicacion.datos.hibernate.dao.implementacion.PrestamoDAOImp;
import aplicacion.datos.hibernate.mapeos.Prestamos;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tomas
 */
@ManagedBean
@ViewScoped
public class PrestamoBean {

    /**
     * Creates a new instance of PrestamoManagedBean
     */
    public PrestamoBean() {
    }

    public void agregarPrestamo(Prestamos unPrestamo) {
        PrestamoDAO prestamoDAO = new PrestamoDAOImp();
        prestamoDAO.agregar(unPrestamo);
    }

    public List<Prestamos> listarPrestamos() {
        PrestamoDAO prestamoDAO = new PrestamoDAOImp();
        return prestamoDAO.obtenerTodos();
    }

    public void modificarPrestamo(Prestamos unPrestamo) {
        PrestamoDAO prestamoDAO = new PrestamoDAOImp();
        prestamoDAO.modificar(unPrestamo);
    }
}
