/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PubAutBean;
import aplicacion.datos.hibernate.mapeos.Autores;
import aplicacion.datos.hibernate.mapeos.PubAut;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
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
public class PubAutManagedBean {

    private Integer paCodigo;
    private Autores autores;
    private Publicaciones publicaciones;
    private boolean paEstado;
    private PubAutBean pubAutBean;
    private List<PubAut> pubAutEncontrados;
    private PubAut unPubAut;

    /**
     * Creates a new instance of PubAutManagedBean
     */
    public PubAutManagedBean() {
        pubAutBean = new PubAutBean();
        listarPubAut();
    }

    private void listarPubAut() {
        setPubAutEncontrados(getPubAutBean().listarPubAut());
    }

    public void establecerPubAut(PubAut det) {
        setUnPubAut(det);
    }

    public void agregarPubAut() {
        setUnPubAut(new PubAut(getAutores(), getPublicaciones(), true));
        try {
            getPubAutBean().agregarPubAut(getUnPubAut());
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "PubAut no se ha podido agregar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", " El PubAut reservas se ha agregado");

        FacesContext.getCurrentInstance()
                .addMessage(null, facesMessage);
        listarPubAut();
        /**
         * @return the drevCodigo
         */
    }

    public void eliminarPubAut() {
        setPaEstado(false);
        getPubAutBean().modificarPubAut(getUnPubAut());
        listarPubAut();
    }

    /**
     * @return the paCodigo
     */
    public Integer getPaCodigo() {
        return paCodigo;
    }

    /**
     * @param paCodigo the paCodigo to set
     */
    public void setPaCodigo(Integer paCodigo) {
        this.paCodigo = paCodigo;
    }

    /**
     * @return the autores
     */
    public Autores getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(Autores autores) {
        this.autores = autores;
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
     * @return the paEstado
     */
    public boolean isPaEstado() {
        return paEstado;
    }

    /**
     * @param paEstado the paEstado to set
     */
    public void setPaEstado(boolean paEstado) {
        this.paEstado = paEstado;
    }

    /**
     * @return the pubAutBean
     */
    public PubAutBean getPubAutBean() {
        return pubAutBean;
    }

    /**
     * @param pubAutBean the pubAutBean to set
     */
    public void setPubAutBean(PubAutBean pubAutBean) {
        this.pubAutBean = pubAutBean;
    }

    /**
     * @return the pubAutEncontrados
     */
    public List<PubAut> getPubAutEncontrados() {
        return pubAutEncontrados;
    }

    /**
     * @param pubAutEncontrados the pubAutEncontrados to set
     */
    public void setPubAutEncontrados(List<PubAut> pubAutEncontrados) {
        this.pubAutEncontrados = pubAutEncontrados;
    }

    /**
     * @return the unPubAut
     */
    public PubAut getUnPubAut() {
        return unPubAut;
    }

    /**
     * @param unPubAut the unPubAut to set
     */
    public void setUnPubAut(PubAut unPubAut) {
        this.unPubAut = unPubAut;
    }
}
