/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PubAutDAO;
import aplicacion.datos.hibernate.dao.implementacion.PubAutDAOImp;
import aplicacion.datos.hibernate.mapeos.PubAut;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tomas
 */
@ManagedBean
@ViewScoped
public class PubAutBean {

    /**
     * Creates a new instance of PubAutBean
     */
    public PubAutBean() {
    }
    
    public void agregarPubAut(PubAut unPubAut){
        PubAutDAO pubAutDAO = new PubAutDAOImp();
        pubAutDAO.agregar(unPubAut);
    }
    public List<PubAut> listarPubAut(){
        PubAutDAO pubAutDAO = new PubAutDAOImp();
        return pubAutDAO.obtenerTodos();
    }
    public void modificarPubAut(PubAut unPubAut){
        PubAutDAO pubAutDAO = new PubAutDAOImp();
        pubAutDAO.modificar(unPubAut);
    }
}
