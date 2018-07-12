/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DetallesReservaBean;
import aplicacion.controlador.beans.PrestamoBean;
import aplicacion.datos.hibernate.mapeos.DetallesReservas;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Prestamos;
import java.util.Date;
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
public class PrestamoManagedBean {

    private Integer preCodigo;
    private Perfiles perfiles;
    private Date preFechaPrestamo;
    private boolean preEstado;
    private String preAdministrativo;
    private PrestamoBean prestamoBean;
    private List<Prestamos> prestamosEncontrados;
    private Prestamos unPrestamo;

    /**
     * Creates a new instance of PrestamoManagedBean
     */
    public PrestamoManagedBean() {
        prestamoBean = new PrestamoBean();
        listarPrestamos();
    }

    private void listarPrestamos() {
        setPrestamosEncontrados(getPrestamoBean().listarPrestamos());
    }

    public void establecerPrestamos(Prestamos det) {
        setUnPrestamo(det);
    }

    public void agregarPrestamo() {
        setUnPrestamo(new Prestamos(getPerfiles(), getPreFechaPrestamo(), true, getPreAdministrativo()));
        try {
            getPrestamoBean().agregarPrestamo(getUnPrestamo());
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "Prestamo no se ha podido agregar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", " El prestamo se ha agregado");

        FacesContext.getCurrentInstance()
                .addMessage(null, facesMessage);
        listarPrestamos();
    }
    
    public void eliminarDetallesPrestamos() {
		setPreEstado(false);
		getPrestamoBean().modificarPrestamo(getUnPrestamo());
		listarPrestamos();
	}
    
    /**
     * @return the preCodigo
     */
    public Integer getPreCodigo() {
        return preCodigo;
    }

    /**
     * @param preCodigo the preCodigo to set
     */
    public void setPreCodigo(Integer preCodigo) {
        this.preCodigo = preCodigo;
    }

    /**
     * @return the perfiles
     */
    public Perfiles getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }

    /**
     * @return the preFechaPrestamo
     */
    public Date getPreFechaPrestamo() {
        return preFechaPrestamo;
    }

    /**
     * @param preFechaPrestamo the preFechaPrestamo to set
     */
    public void setPreFechaPrestamo(Date preFechaPrestamo) {
        this.preFechaPrestamo = preFechaPrestamo;
    }

    /**
     * @return the preEstado
     */
    public boolean isPreEstado() {
        return preEstado;
    }

    /**
     * @param preEstado the preEstado to set
     */
    public void setPreEstado(boolean preEstado) {
        this.preEstado = preEstado;
    }

    /**
     * @return the preAdministrativo
     */
    public String getPreAdministrativo() {
        return preAdministrativo;
    }

    /**
     * @param preAdministrativo the preAdministrativo to set
     */
    public void setPreAdministrativo(String preAdministrativo) {
        this.preAdministrativo = preAdministrativo;
    }

    /**
     * @return the prestamoBean
     */
    public PrestamoBean getPrestamoBean() {
        return prestamoBean;
    }

    /**
     * @param prestamoBean the prestamoBean to set
     */
    public void setPrestamoBean(PrestamoBean prestamoBean) {
        this.prestamoBean = prestamoBean;
    }

    /**
     * @return the prestamosEncontrados
     */
    public List<Prestamos> getPrestamosEncontrados() {
        return prestamosEncontrados;
    }

    /**
     * @param prestamosEncontrados the prestamosEncontrados to set
     */
    public void setPrestamosEncontrados(List<Prestamos> prestamosEncontrados) {
        this.prestamosEncontrados = prestamosEncontrados;
    }

    /**
     * @return the unPrestamo
     */
    public Prestamos getUnPrestamo() {
        return unPrestamo;
    }

    /**
     * @param unPrestamo the unPrestamo to set
     */
    public void setUnPrestamo(Prestamos unPrestamo) {
        this.unPrestamo = unPrestamo;
    }

}
