/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PubClaBean;
import aplicacion.datos.hibernate.mapeos.Clasificaciones;
import aplicacion.datos.hibernate.mapeos.Editoriales;
import aplicacion.datos.hibernate.mapeos.PubCla;
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
public class PubClaManagedBean {
    @ManagedProperty(value="#{pubClaBean}")
    private Integer pcCodigo;
     private Clasificaciones clasificaciones;
     private Publicaciones publicaciones;
     private boolean pcEstado;
     private PubClaBean pubClaBean;
     private List<PubCla> perfilesEncontrados;
     private PubCla pubCla;
      private String pubCodigo;
      private Editoriales editoriales;
      private String pubNombre;
     private String pubResumen;
      private boolean pubEstado;
      private String pubTipo;
     private int pubStock;
     private Integer ediCodigo;
     private String editNombre;
     private boolean editEstado;
      private Integer claCodigo;
     private int claIdentificador;
     private String claDescripcion;
    /**
     * Creates a new instance of PubClaManagedBean
     */
    public PubClaManagedBean() {
        pubClaBean=new PubClaBean();
        listarPerfiles();
    }
    private void listarPerfiles(){
        setPerfilesEncontrados(getPubClaBean().listarPerfiles());
    }
    public void establecerPerfil(PubCla per){
        setPubCla(per);
    }
    public void agregarPerfil(){
        setEditoriales(new Editoriales(1, getEditNombre(), true));
        setPublicaciones(new Publicaciones(getPubCodigo(), getEditoriales(), getPubNombre(), getPubResumen(), true, getPubTipo(), getPubStock()));
        setClasificaciones(new Clasificaciones(1, getClaIdentificador(), getClaDescripcion()));
        setPubCla(new PubCla(1, getClasificaciones(), getPublicaciones(), true));
        try{
            getPubClaBean().agregarPerfil(getPubCla());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR","La pub no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO","La pub se ha podido crear");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPerfiles();
    }
    public void eliminarPerfil(){
        getPubCla().getPublicaciones().setPubEstado(false);
        getPubCla().getPublicaciones().getEditoriales().setEditEstado(false);
        getPubCla().setPcEstado(false);
        getPubClaBean().modificarPerfil(getPubCla());
        listarPerfiles();
        
    }

    /**
     * @return the pcCodigo
     */
    public Integer getPcCodigo() {
        return pcCodigo;
    }

    /**
     * @param pcCodigo the pcCodigo to set
     */
    public void setPcCodigo(Integer pcCodigo) {
        this.pcCodigo = pcCodigo;
    }

    /**
     * @return the clasificaciones
     */
    public Clasificaciones getClasificaciones() {
        return clasificaciones;
    }

    /**
     * @param clasificaciones the clasificaciones to set
     */
    public void setClasificaciones(Clasificaciones clasificaciones) {
        this.clasificaciones = clasificaciones;
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
     * @return the pcEstado
     */
    public boolean isPcEstado() {
        return pcEstado;
    }

    /**
     * @param pcEstado the pcEstado to set
     */
    public void setPcEstado(boolean pcEstado) {
        this.pcEstado = pcEstado;
    }

    /**
     * @return the pubClaBean
     */
    public PubClaBean getPubClaBean() {
        return pubClaBean;
    }

    /**
     * @param pubClaBean the pubClaBean to set
     */
    public void setPubClaBean(PubClaBean pubClaBean) {
        this.pubClaBean = pubClaBean;
    }

    /**
     * @return the perfilesEncontrados
     */
    public List<PubCla> getPerfilesEncontrados() {
        return perfilesEncontrados;
    }

    /**
     * @param perfilesEncontrados the perfilesEncontrados to set
     */
    public void setPerfilesEncontrados(List<PubCla> perfilesEncontrados) {
        this.perfilesEncontrados = perfilesEncontrados;
    }

    /**
     * @return the pubCla
     */
    public PubCla getPubCla() {
        return pubCla;
    }

    /**
     * @param pubCla the pubCla to set
     */
    public void setPubCla(PubCla pubCla) {
        this.pubCla = pubCla;
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

    /**
     * @return the editEstado
     */
    public boolean isEditEstado() {
        return editEstado;
    }

    /**
     * @param editEstado the editEstado to set
     */
    public void setEditEstado(boolean editEstado) {
        this.editEstado = editEstado;
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
}
