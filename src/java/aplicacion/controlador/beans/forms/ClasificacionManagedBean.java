/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ClasificacionBean;
import aplicacion.datos.hibernate.mapeos.Clasificaciones;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tomas Fernandez EdM
 */
@ManagedBean
@ViewScoped
public class ClasificacionManagedBean implements Serializable {

	@ManagedProperty(value = "#{clasificacionBean}")
        private ClasificacionBean clasificacionBean;
	private Integer claCodigo;
	private int claIdentificador;
	private String claDescripcion;
	private List<Clasificaciones> clasificacionesEncontradas;
	private Clasificaciones unaClasificacion;

	/**
	 * Creates a new instance of ClasificacionManagedBean
	 */
	public ClasificacionManagedBean() {
		clasificacionBean = new ClasificacionBean();
		listarClasificaciones();
	}

	private void listarClasificaciones() {
		setClasificacionesEncontradas(getClasificacionBean().listarClasificaciones());
	}

	public void establecerClasificacion(Clasificaciones clas) {
		setUnaClasificacion(clas);
	}

	public void agregarClasificacion() {
		setUnaClasificacion(new Clasificaciones(1, getClaIdentificador(), getClaDescripcion()));
		try {
			getClasificacionBean().agregarClasificacion(getUnaClasificacion());
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "La clasificacion no se ha podido agregar");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "La clasificacion se ha agregado");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		listarClasificaciones();
	}
        public void modificarEditorial(){
        unaClasificacion.setClaIdentificador(claIdentificador);
        unaClasificacion.setClaDescripcion(claDescripcion);
        clasificacionBean.modificarClasificacion(unaClasificacion);
        listarClasificaciones();
        }
	/**
	 * @return the claCodigo
	 */
	public Integer getClaCodigo() {
		return claCodigo;
	}

	/**
	 * @param claCodigo the claCodigo to set
	 */
	public void setClaCodigo(Integer claCodigo) {
		this.claCodigo = claCodigo;
	}

	/**
	 * @return the claIdentificador
	 */
	public int getClaIdentificador() {
		return claIdentificador;
	}

	/**
	 * @param claIdentificador the claIdentificador to set
	 */
	public void setClaIdentificador(int claIdentificador) {
		this.claIdentificador = claIdentificador;
	}

	/**
	 * @return the claDescripcion
	 */
	public String getClaDescripcion() {
		return claDescripcion;
	}

	/**
	 * @param claDescripcion the claDescripcion to set
	 */
	public void setClaDescripcion(String claDescripcion) {
		this.claDescripcion = claDescripcion;
	}

	/**
	 * @return the clasificacionBean
	 */
	public ClasificacionBean getClasificacionBean() {
		return clasificacionBean;
	}

	/**
	 * @param clasificacionBean the clasificacionBean to set
	 */
	public void setClasificacionBean(ClasificacionBean clasificacionBean) {
		this.clasificacionBean = clasificacionBean;
	}

	/**
	 * @return the clasificacionesEncontradas
	 */
	public List<Clasificaciones> getClasificacionesEncontradas() {
		return clasificacionesEncontradas;
	}

	/**
	 * @param clasificacionesEncontradas the clasificacionesEncontradas to set
	 */
	public void setClasificacionesEncontradas(List<Clasificaciones> clasificacionesEncontradas) {
		this.clasificacionesEncontradas = clasificacionesEncontradas;
	}

	/**
	 * @return the unaClasificacion
	 */
	public Clasificaciones getUnaClasificacion() {
		return unaClasificacion;
	}

	/**
	 * @param unaClasificacion the unaClasificacion to set
	 */
	public void setUnaClasificacion(Clasificaciones unaClasificacion) {
		this.unaClasificacion = unaClasificacion;
	}
}
