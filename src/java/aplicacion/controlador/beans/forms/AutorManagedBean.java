/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AutorBean;
import aplicacion.datos.hibernate.mapeos.Autores;
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
public class AutorManagedBean {

    private Integer autCodigo;
    private String autApellidos;
    private String autNombres;
    private Autores unAutor;
    private List<Autores> autoresEncontrados;
    private AutorBean autorBean;

    /**
     * Creates a new instance of AutorManagedBean
     */
    public AutorManagedBean() {
        autorBean = new AutorBean();
        listarAutores();
    }

    private void listarAutores() {
        setAutoresEncontrados(getAutorBean().listarAutores());
    }

    public void establecerAutor(Autores aut) {
        setUnAutor(aut);
    }

    public void agregarAutor() {
        setUnAutor(new Autores(getAutApellidos(), getAutNombres()));
        try {
            getAutorBean().agregarAutor(getUnAutor());
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "El Autor no se ha podido agregar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "El Autor se ha agregado");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarAutores();
    }
    public void eliminarEditorial(){
        unAutor.setAutCodigo(null);
        autorBean.modificarAutor(unAutor);
        listarAutores();
    }
    public void modificarEditorial(){
        unAutor.setAutNombres(autNombres);
        unAutor.setAutApellidos(autApellidos);
        autorBean.modificarAutor(unAutor);
        listarAutores();
    }
    /**
     * @return the autCodigo
     */
    public Integer getAutCodigo() {
        return autCodigo;
    }

    /**
     * @param autCodigo the autCodigo to set
     */
    public void setAutCodigo(Integer autCodigo) {
        this.autCodigo = autCodigo;
    }

    /**
     * @return the autApellidos
     */
    public String getAutApellidos() {
        return autApellidos;
    }

    /**
     * @param autApellidos the autApellidos to set
     */
    public void setAutApellidos(String autApellidos) {
        this.autApellidos = autApellidos;
    }

    /**
     * @return the autNombres
     */
    public String getAutNombres() {
        return autNombres;
    }

    /**
     * @param autNombres the autNombres to set
     */
    public void setAutNombres(String autNombres) {
        this.autNombres = autNombres;
    }

    /**
     * @return the unAutor
     */
    public Autores getUnAutor() {
        return unAutor;
    }

    /**
     * @param unAutor the unAutor to set
     */
    public void setUnAutor(Autores unAutor) {
        this.unAutor = unAutor;
    }

    /**
     * @return the autoresEncontrados
     */
    public List<Autores> getAutoresEncontrados() {
        return autoresEncontrados;
    }

    /**
     * @param autoresEncontrados the autoresEncontrados to set
     */
    public void setAutoresEncontrados(List<Autores> autoresEncontrados) {
        this.autoresEncontrados = autoresEncontrados;
    }

    /**
     * @return the autorBean
     */
    public AutorBean getAutorBean() {
        return autorBean;
    }

    /**
     * @param autorBean the autorBean to set
     */
    public void setAutorBean(AutorBean autorBean) {
        this.autorBean = autorBean;
    }

}
