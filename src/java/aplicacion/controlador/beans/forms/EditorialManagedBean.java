/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.EditorialBean;
import aplicacion.datos.hibernate.mapeos.Editoriales;
import java.io.Serializable;
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
public class EditorialManagedBean implements Serializable {
    @ManagedProperty(value="#{editorialBean}")
    private EditorialBean editorialBean;
    private String editNombre;
    private boolean editEstado;    
    private List<Editoriales> editorialesEncontradas;
    private Editoriales unaEditorial;
    

    /**
     * Creates a new instance of EditorialManagedBean
     */
    public EditorialManagedBean() {
        editorialBean=new EditorialBean();
        listarEditoriales();
    }
    private void listarEditoriales(){
        setEditorialesEncontradas(getEditorialBean().listarEditoriales());
    }
    public void establecerEditorial(Editoriales ed){
        setUnaEditorial(ed);
    }
    public void agregarEditorial(){
        setEditEstado(true);
        setUnaEditorial(new Editoriales(1, getEditNombre(), isEditEstado()));
        try{
            getEditorialBean().agregarEditorial(getUnaEditorial());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR","La editorial no se ha podido agregar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO","La editorial se ha agregado");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarEditoriales();
    }
    public void eliminarEditorial(){
        getUnaEditorial().setEditEstado(false);
        getEditorialBean().modificarPerfil(getUnaEditorial());
        listarEditoriales();
    }
    public void modificarEditorial(){
        getUnaEditorial().setEditNombre(editNombre);
        getEditorialBean().modificarPerfil(getUnaEditorial());
        listarEditoriales();
    }

    /**
     * @return the ediCodigo
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
     * @return the editorialBean
     */
    public EditorialBean getEditorialBean() {
        return editorialBean;
    }

    /**
     * @param editorialBean the editorialBean to set
     */
    public void setEditorialBean(EditorialBean editorialBean) {
        this.editorialBean = editorialBean;
    }

    /**
     * @return the editorialesEncontradas
     */
    public List<Editoriales> getEditorialesEncontradas() {
        return editorialesEncontradas;
    }

    /**
     * @param editorialesEncontradas the editorialesEncontradas to set
     */
    public void setEditorialesEncontradas(List<Editoriales> editorialesEncontradas) {
        this.editorialesEncontradas = editorialesEncontradas;
    }

    /**
     * @return the unaEditorial
     */
    public Editoriales getUnaEditorial() {
        return unaEditorial;
    }

    /**
     * @param unaEditorial the unaEditorial to set
     */
    public void setUnaEditorial(Editoriales unaEditorial) {
        this.unaEditorial = unaEditorial;
    }
}
