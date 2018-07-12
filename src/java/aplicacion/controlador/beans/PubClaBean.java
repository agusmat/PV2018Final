/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PubClaDAO;
import aplicacion.datos.hibernate.dao.implementacion.PubClaDAOImp;
import aplicacion.datos.hibernate.mapeos.PubCla;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class PubClaBean {

    /**
     * Creates a new instance of PubClaBean
     */
    public PubClaBean() {
    }
    public void agregarPerfil(PubCla unPerfil){
        PubClaDAO perfilDAO=new PubClaDAOImp();
        perfilDAO.agregar(unPerfil);
    }
    public List<PubCla> listarPerfiles(){
        PubClaDAO perfilDAO=new PubClaDAOImp();
        return perfilDAO.obtenerTodos();
    }
    public void modificarPerfil(PubCla unPerfil){
        PubClaDAO perfilDAO=new PubClaDAOImp();
        perfilDAO.modificar(unPerfil);
    }
}
