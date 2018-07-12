/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DetallesPrestamoBean;
import aplicacion.datos.hibernate.mapeos.DetallesPrestamos;
import aplicacion.datos.hibernate.mapeos.Prestamos;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tomas Fernandez EdM
 */
@ManagedBean
@ViewScoped
public class DetallesPrestamoManagedBean {

	private Integer dpCodigo;
	private Prestamos prestamos;
	private Publicaciones publicaciones;
	private boolean dpEstado;
	private Date dpFechaADevolver;
	private String dpTurno;
	private Date dpFechaDevolucion;
	private DetallesPrestamoBean detallesPrestamoBean;
	private List<DetallesPrestamos> detallesPrestamosEncontrados;
	private DetallesPrestamos unDetallesPrestamos;

	/**
	 * Creates a new instance of DetallesPrestamoManagedBean
	 */
	public DetallesPrestamoManagedBean() {
		detallesPrestamoBean = new DetallesPrestamoBean();
		listarDetallesPrestamo();
	}

	private void listarDetallesPrestamo() {
		setDetallesPrestamosEncontrados(getDetallesPrestamoBean().listarDetallesPrestamos());
	}

	public void establecerDetallesPrestamo(DetallesPrestamos det) {
		setUnDetallesPrestamos(det);
	}

	public void agregarDetallesPrestamo() {
		setUnDetallesPrestamos(new DetallesPrestamos(getPrestamos(), getPublicaciones(), isDpEstado(), getDpFechaADevolver(), getDpTurno(), getDpFechaDevolucion()));
		try {
			getDetallesPrestamoBean().agregarDetallesPrestamo(getUnDetallesPrestamos());
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "DetallesPrestamos no se ha podido agregar");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", " El detalles Prestamos se ha agregado");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		listarDetallesPrestamo();
	}

	public void eliminarDetallesPrestamos() {
		setDpEstado(false);
		getDetallesPrestamoBean().modificarDetallesPrestamo(getUnDetallesPrestamos());
		listarDetallesPrestamo();
	}

	/**
	 * @return the dpCodigo
	 */
	public Integer getDpCodigo() {
		return dpCodigo;
	}

	/**
	 * @param dpCodigo the dpCodigo to set
	 */
	public void setDpCodigo(Integer dpCodigo) {
		this.dpCodigo = dpCodigo;
	}

	/**
	 * @return the prestamos
	 */
	public Prestamos getPrestamos() {
		return prestamos;
	}

	/**
	 * @param prestamos the prestamos to set
	 */
	public void setPrestamos(Prestamos prestamos) {
		this.prestamos = prestamos;
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
	 * @return the dpEstado
	 */
	public boolean isDpEstado() {
		return dpEstado;
	}

	/**
	 * @param dpEstado the dpEstado to set
	 */
	public void setDpEstado(boolean dpEstado) {
		this.dpEstado = dpEstado;
	}

	/**
	 * @return the dpFechaADevolver
	 */
	public Date getDpFechaADevolver() {
		return dpFechaADevolver;
	}

	/**
	 * @param dpFechaADevolver the dpFechaADevolver to set
	 */
	public void setDpFechaADevolver(Date dpFechaADevolver) {
		this.dpFechaADevolver = dpFechaADevolver;
	}

	/**
	 * @return the dpTurno
	 */
	public String getDpTurno() {
		return dpTurno;
	}

	/**
	 * @param dpTurno the dpTurno to set
	 */
	public void setDpTurno(String dpTurno) {
		this.dpTurno = dpTurno;
	}

	/**
	 * @return the dpFechaDevolucion
	 */
	public Date getDpFechaDevolucion() {
		return dpFechaDevolucion;
	}

	/**
	 * @param dpFechaDevolucion the dpFechaDevolucion to set
	 */
	public void setDpFechaDevolucion(Date dpFechaDevolucion) {
		this.dpFechaDevolucion = dpFechaDevolucion;
	}

	/**
	 * @return the detallesPrestamoBean
	 */
	public DetallesPrestamoBean getDetallesPrestamoBean() {
		return detallesPrestamoBean;
	}

	/**
	 * @param detallesPrestamoBean the detallesPrestamoBean to set
	 */
	public void setDetallesPrestamoBean(DetallesPrestamoBean detallesPrestamoBean) {
		this.detallesPrestamoBean = detallesPrestamoBean;
	}

	/**
	 * @return the detallesPrestamosEncontrados
	 */
	public List<DetallesPrestamos> getDetallesPrestamosEncontrados() {
		return detallesPrestamosEncontrados;
	}

	/**
	 * @param detallesPrestamosEncontrados the detallesPrestamosEncontrados to set
	 */
	public void setDetallesPrestamosEncontrados(List<DetallesPrestamos> detallesPrestamosEncontrados) {
		this.detallesPrestamosEncontrados = detallesPrestamosEncontrados;
	}

	/**
	 * @return the unDetallesPrestamos
	 */
	public DetallesPrestamos getUnDetallesPrestamos() {
		return unDetallesPrestamos;
	}

	/**
	 * @param unDetallesPrestamos the unDetallesPrestamos to set
	 */
	public void setUnDetallesPrestamos(DetallesPrestamos unDetallesPrestamos) {
		this.unDetallesPrestamos = unDetallesPrestamos;
	}
}
