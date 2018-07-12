/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DetallesReservaBean;
import aplicacion.datos.hibernate.mapeos.DetallesReservas;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import aplicacion.datos.hibernate.mapeos.Reservas;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tomas
 */
@ManagedBean
@ViewScoped
public class DetallesReservaManagedBean {

    private Integer drevCodigo;
    private Publicaciones publicaciones;
    private Reservas reservas;
    private int drevCantidad;
    private boolean drevEstado;
    private DetallesReservaBean detallesReservaBean;
    private List<DetallesReservas> detallesReservasEncontrados;
    private DetallesReservas unDetallesReserva;

    /**
     * Creates a new instance of DetallesReservaManagedBean
     */
    public DetallesReservaManagedBean() {
        detallesReservaBean = new DetallesReservaBean();
        listarDetallesReserva();
    }

    private void listarDetallesReserva() {
        setDetallesReservasEncontrados(getDetallesReservaBean().listarDetallesReservas());
    }

    public void establecerDetallesReserva(DetallesReservas det) {
        setUnDetallesReserva(det);
    }

    public void agregarDetallesReserva() {
        setUnDetallesReserva(new DetallesReservas(getPublicaciones(), getReservas(), getDrevCantidad(), true));
        try {
            getDetallesReservaBean().agregarDetallesReserva(getUnDetallesReserva());
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "DetallesReserva no se ha podido agregar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", " El detalles reservas se ha agregado");

        FacesContext.getCurrentInstance()
                .addMessage(null, facesMessage);
        listarDetallesReserva();
        /**
         * @return the drevCodigo
         */
    }
    
    public void eliminarDetallesPrestamos() {
		setDrevEstado(false);
		getDetallesReservaBean().modificarDetallesReserva(getUnDetallesReserva());
		listarDetallesReserva();
	}
    
    public Integer getDrevCodigo() {
        return drevCodigo;
    }

    /**
     * @param drevCodigo the drevCodigo to set
     */
    public void setDrevCodigo(Integer drevCodigo) {
        this.drevCodigo = drevCodigo;
    }

    /**
     * @return the publicaciones
     */
    public Publicaciones getPublicaciones() {
        return publicaciones;
    }

    /**
     * @param publicaciones the publicaciones to set
     */
    public void setPublicaciones(Publicaciones publicaciones) {
        this.publicaciones = publicaciones;
    }

    /**
     * @return the reservas
     */
    public Reservas getReservas() {
        return reservas;
    }

    /**
     * @param reservas the reservas to set
     */
    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }

    /**
     * @return the drevCantidad
     */
    public int getDrevCantidad() {
        return drevCantidad;
    }

    /**
     * @param drevCantidad the drevCantidad to set
     */
    public void setDrevCantidad(int drevCantidad) {
        this.drevCantidad = drevCantidad;
    }

    /**
     * @return the drevEstado
     */
    public boolean isDrevEstado() {
        return drevEstado;
    }

    /**
     * @param drevEstado the drevEstado to set
     */
    public void setDrevEstado(boolean drevEstado) {
        this.drevEstado = drevEstado;
    }

    /**
     * @return the detallesReservaBean
     */
    public DetallesReservaBean getDetallesReservaBean() {
        return detallesReservaBean;
    }

    /**
     * @param detallesReservaBean the detallesReservaBean to set
     */
    public void setDetallesReservaBean(DetallesReservaBean detallesReservaBean) {
        this.detallesReservaBean = detallesReservaBean;
    }

    /**
     * @return the detallesReservasEncontrados
     */
    public List<DetallesReservas> getDetallesReservasEncontrados() {
        return detallesReservasEncontrados;
    }

    /**
     * @param detallesReservasEncontrados the detallesReservasEncontrados to set
     */
    public void setDetallesReservasEncontrados(List<DetallesReservas> detallesReservasEncontrados) {
        this.detallesReservasEncontrados = detallesReservasEncontrados;
    }

    /**
     * @return the unDetallesReserva
     */
    public DetallesReservas getUnDetallesReserva() {
        return unDetallesReserva;
    }

    /**
     * @param unDetallesReserva the unDetallesReserva to set
     */
    public void setUnDetallesReserva(DetallesReservas unDetallesReserva) {
        this.unDetallesReserva = unDetallesReserva;
    }
}

