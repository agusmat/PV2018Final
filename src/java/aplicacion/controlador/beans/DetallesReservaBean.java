/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.DetallesReservaDAO;
import aplicacion.datos.hibernate.dao.implementacion.DetallesReservaDAOImp;
import aplicacion.datos.hibernate.mapeos.DetallesReservas;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tomas
 */
@ManagedBean
@ViewScoped
public class DetallesReservaBean {

    /**
     * Creates a new instance of DetallesReservaBean
     */
    public DetallesReservaBean() {
    }
    
    public void agregarDetallesReserva(DetallesReservas unDetallesReservas){
        DetallesReservaDAO detallesReservaDAO=new DetallesReservaDAOImp();
        detallesReservaDAO.agregar(unDetallesReservas);
    }
    public List<DetallesReservas> listarDetallesReservas(){
        DetallesReservaDAO detallesReservaDAO=new DetallesReservaDAOImp();
        return detallesReservaDAO.obtenerTodos();
    }
    public void modificarDetallesReserva(DetallesReservas unDetallesReservas){
        DetallesReservaDAO detallesReservaDAO=new DetallesReservaDAOImp();
        detallesReservaDAO.modificar(unDetallesReservas);
    }
}
