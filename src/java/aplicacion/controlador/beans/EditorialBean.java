/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.EditorialDAO;
import aplicacion.datos.hibernate.dao.implementacion.EditorialDAOImp;
import aplicacion.datos.hibernate.mapeos.Editoriales;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class EditorialBean {

    /**
     * Creates a new instance of EditorialBean
     */
    public EditorialBean() {
    }
    public void agregarEditorial(Editoriales unPerfil){
        EditorialDAO editorialDAO=new EditorialDAOImp();
        editorialDAO.agregar(unPerfil);
    }
    public List<Editoriales> listarEditoriales(){
        EditorialDAO editorialDAO=new EditorialDAOImp();
        return editorialDAO.obtenerTodos();
    }
    public void modificarPerfil(Editoriales unPerfil){
        EditorialDAO editorialDAO=new EditorialDAOImp();
        editorialDAO.modificar(unPerfil);
    }
}
