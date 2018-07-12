/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.AutorDAO;
import aplicacion.datos.hibernate.dao.implementacion.AutorDAOImp;
import aplicacion.datos.hibernate.mapeos.Autores;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tomas
 */
@ManagedBean
@ViewScoped
public class AutorBean {

    /**
     * Creates a new instance of AutorBean
     */
    public AutorBean() {
    }

    public void agregarAutor(Autores unAutor) {
        AutorDAO autorDAO = new AutorDAOImp();
        autorDAO.agregar(unAutor);
    }

    public List<Autores> listarAutores() {
        AutorDAO autorDAO = new AutorDAOImp();
        return autorDAO.obtenerTodos();
    }

    public void modificarAutor(Autores unAutor) {
        AutorDAO autorDAO = new AutorDAOImp();
        autorDAO.modificar(unAutor);
    }
}
