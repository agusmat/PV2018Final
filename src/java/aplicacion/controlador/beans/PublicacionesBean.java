/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PublicacionesDAO;
import aplicacion.datos.hibernate.dao.implementacion.PublicacionesDAOImp;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class PublicacionesBean {

    /**
     * Creates a new instance of PublicacionesBean
     */
    public PublicacionesBean() {
    }
    public void agregarEditorial(Publicaciones unPerfil){
        PublicacionesDAO editorialDAO=new PublicacionesDAOImp();
        editorialDAO.agregar(unPerfil);
    }
    public List<Publicaciones> listarEditoriales(){
        PublicacionesDAO editorialDAO=new PublicacionesDAOImp();
        return editorialDAO.obtenerTodos();
    }
    public void modificarPerfil(Publicaciones unPerfil){
        PublicacionesDAO editorialDAO=new PublicacionesDAOImp();
        editorialDAO.modificar(unPerfil);
    }
}
