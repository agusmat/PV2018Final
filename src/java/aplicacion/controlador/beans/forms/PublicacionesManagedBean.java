/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PublicacionesBean;
import aplicacion.datos.hibernate.mapeos.Editoriales;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class PublicacionesManagedBean {
     @ManagedProperty(value="#{publicacionesBean}")
     private PublicacionesBean publicacionesBean;
     private String pubCodigo;
     private Editoriales editoriales;
     private String pubNombre;
     private String pubResumen;
     private boolean pubEstado;
     private String pubTipo;
     private int pubStock;
     
     private List<Publicaciones> listaPublicaciones;
     private Publicaciones unaPublicacion;
     private Integer ediCodigo;
     private String editNombre;
    /**
     * Creates a new instance of PublicacionesManagedBean
     */
    public PublicacionesManagedBean() {
        publicacionesBean=new PublicacionesBean();
        listarPublicaciones();
    }
    private void listarPublicaciones(){
        setListaPublicaciones(getPublicacionesBean().listarEditoriales());
    }
    public void establecerPerfil(Publicaciones per){
        setUnaPublicacion(per);
    }
    public void agregarPerfil(){
        setUnaPublicacion(new Publicaciones(getPubCodigo(), getEditoriales(), getPubNombre(), getPubResumen(), true, getPubTipo(), getPubStock()));
        try{
            getPublicacionesBean().agregarEditorial(getUnaPublicacion());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR","La Publicacion no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO","La publicacion se ha podido crear");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPublicaciones();
    }
    public void eliminarPerfil(){
        getUnaPublicacion().setPubEstado(false);
        getUnaPublicacion().getEditoriales().setEditEstado(false);
        getPublicacionesBean().modificarPerfil(getUnaPublicacion());
        listarPublicaciones();
    }
    public void modificarEditorial(){
        unaPublicacion.setEditoriales(editoriales);
        unaPublicacion.setPubStock(pubStock);
        unaPublicacion.setPubNombre(pubNombre);
        unaPublicacion.setPubResumen(pubResumen);
        unaPublicacion.setPubCodigo(pubCodigo);
        unaPublicacion.setPubTipo(pubTipo);
        getPublicacionesBean().modificarPerfil(getUnaPublicacion());
        listarPublicaciones();
    }
    /**
     * @return the pubCodigo
     */
    public String getPubCodigo() {
        return pubCodigo;
    }

    /**
     * @param pubCodigo the pubCodigo to set
     */
    public void setPubCodigo(String pubCodigo) {
        this.pubCodigo = pubCodigo;
    }

    /**
     * @return the editoriales
     */
    public Editoriales getEditoriales() {
        return editoriales;
    }

    /**
     * @param editoriales the editoriales to set
     */
    public void setEditoriales(Editoriales editoriales) {
        this.editoriales = editoriales;
    }

    /**
     * @return the pubNombre
     */
    public String getPubNombre() {
        return pubNombre;
    }

    /**
     * @param pubNombre the pubNombre to set
     */
    public void setPubNombre(String pubNombre) {
        this.pubNombre = pubNombre;
    }

    /**
     * @return the pubResumen
     */
    public String getPubResumen() {
        return pubResumen;
    }

    /**
     * @param pubResumen the pubResumen to set
     */
    public void setPubResumen(String pubResumen) {
        this.pubResumen = pubResumen;
    }

    /**
     * @return the pubEstado
     */
    public boolean isPubEstado() {
        return pubEstado;
    }

    /**
     * @param pubEstado the pubEstado to set
     */
    public void setPubEstado(boolean pubEstado) {
        this.pubEstado = pubEstado;
    }

    /**
     * @return the pubTipo
     */
    public String getPubTipo() {
        return pubTipo;
    }

    /**
     * @param pubTipo the pubTipo to set
     */
    public void setPubTipo(String pubTipo) {
        this.pubTipo = pubTipo;
    }

    /**
     * @return the pubStock
     */
    public int getPubStock() {
        return pubStock;
    }

    /**
     * @param pubStock the pubStock to set
     */
    public void setPubStock(int pubStock) {
        this.pubStock = pubStock;
    }

    /**
     * @return the publicacionesBean
     */
    public PublicacionesBean getPublicacionesBean() {
        return publicacionesBean;
    }

    /**
     * @param publicacionesBean the publicacionesBean to set
     */
    public void setPublicacionesBean(PublicacionesBean publicacionesBean) {
        this.publicacionesBean = publicacionesBean;
    }

    /**
     * @return the listaPublicaciones
     */
    public List<Publicaciones> getListaPublicaciones() {
        return listaPublicaciones;
    }

    /**
     * @param listaPublicaciones the listaPublicaciones to set
     */
    public void setListaPublicaciones(List<Publicaciones> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }

    /**
     * @return the unaPublicacion
     */
    public Publicaciones getUnaPublicacion() {
        return unaPublicacion;
    }

    /**
     * @param unaPublicacion the unaPublicacion to set
     */
    public void setUnaPublicacion(Publicaciones unaPublicacion) {
        this.unaPublicacion = unaPublicacion;
    }

    /**
     * @return the ediCodigo
     */
    public Integer getEdiCodigo() {
        return ediCodigo;
    }

    /**
     * @param ediCodigo the ediCodigo to set
     */
    public void setEdiCodigo(Integer ediCodigo) {
        this.ediCodigo = ediCodigo;
    }

    /**
     * @return the editNombre
     */
    public String getEditNombre() {
        return editNombre;
    }

    /**
     * @param editNombre the editNombre to set
     */
    public void setEditNombre(String editNombre) {
        this.editNombre = editNombre;
    }
}
