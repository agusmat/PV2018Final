/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.ReservasDAO;
import aplicacion.datos.hibernate.dao.implementacion.ReservasDAOImp;
import aplicacion.datos.hibernate.mapeos.Reservas;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Tiago
 */
@ManagedBean
@ViewScoped
public class ReservasBean { 
    public ReservasBean() {
    }
    public void agregarReservas(Reservas unPerfil){
        ReservasDAO reservasDAO=new ReservasDAOImp();
        reservasDAO.agregar(unPerfil);
    }
    public List<Reservas> listarEditoriales(){
         ReservasDAO reservasDAO=new ReservasDAOImp();
        return reservasDAO.obtenerTodos();
    }
    public void modificarPerfil(Reservas unPerfil){
         ReservasDAO reservasDAO=new ReservasDAOImp();
        reservasDAO.modificar(unPerfil);
    }
}
