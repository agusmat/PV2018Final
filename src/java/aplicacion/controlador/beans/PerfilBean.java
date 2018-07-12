/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.implementacion.PerfilDAOImp;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class PerfilBean {

    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
    }
    public void agregarPerfil(Perfiles unPerfil){
        PerfilDAO perfilDAO=new PerfilDAOImp();
        perfilDAO.agregar(unPerfil);
    }
    public List<Perfiles> listarPerfiles(){
        PerfilDAO perfilDAO=new PerfilDAOImp();
        return perfilDAO.obtenerTodos();
    }
    public void modificarPerfil(Perfiles unPerfil){
        PerfilDAO perfilDAO=new PerfilDAOImp();
        perfilDAO.modificar(unPerfil);
    }
}
