/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.io.Serializable;
import java.util.Date;
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
public class PerfilManagedBean implements Serializable {
    @ManagedProperty(value="#{perfilBean}")
    private PerfilBean perfilBean;
    private Usuarios unUsuario;
    private Perfiles unPerfil;
    private String nombreUs;
    private String passwUs;
    private String tipos;
    private String nombres;
    private String apellidos;
    private boolean busqueda;
    private List<Perfiles> perfilesEncontrados;
    private String dni;
    
    /**
     * Creates a new instance of PerfilManagedBean
     */
    public PerfilManagedBean() {
        perfilBean=new PerfilBean();
        listarPerfiles();
        
    }
    private void listarPerfiles(){
        setPerfilesEncontrados(getPerfilBean().listarPerfiles());
    }
    public void establecerPerfil(Perfiles per){
        setUnPerfil(per);
    }
    public void agregarPerfil(){        
        setUnPerfil(new Perfiles(true, getUnUsuario(), getApellidos(), getNombres(), "111111", new Date(), "email", "direccion", "telefono"));
        System.out.println("uuuuuuuuuuuuuuuu"+ getUnUsuario().getUsuNombreUsuario());
        try{
            getPerfilBean().agregarPerfil(getUnPerfil());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR","El perfil no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO","El perfil se ha podido crear");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPerfiles();
    }
    public void eliminarPerfil(){
        getUnPerfil().getUsuarios().setUsuEstado(false);
        getUnPerfil().setPerEstado(false);
        getPerfilBean().modificarPerfil(getUnPerfil());
        listarPerfiles();
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    /**
     * @return the unUsuario
     */
    public Usuarios getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuarios unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unPerfil
     */
    public Perfiles getUnPerfil() {
        return unPerfil;
    }

    /**
     * @param unPerfil the unPerfil to set
     */
    public void setUnPerfil(Perfiles unPerfil) {
        this.unPerfil = unPerfil;
    }

    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passwUs
     */
    public String getPasswUs() {
        return passwUs;
    }

    /**
     * @param passwUs the passwUs to set
     */
    public void setPasswUs(String passwUs) {
        this.passwUs = passwUs;
    }

    /**
     * @return the tipos
     */
    public String getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the busqueda
     */
    public boolean isBusqueda() {
        return busqueda;
    }

    /**
     * @param busqueda the busqueda to set
     */
    public void setBusqueda(boolean busqueda) {
        this.busqueda = busqueda;
    }

    /**
     * @return the perfilesEncontrados
     */
    public List<Perfiles> getPerfilesEncontrados() {
        return perfilesEncontrados;
    }

    /**
     * @param perfilesEncontrados the perfilesEncontrados to set
     */
    public void setPerfilesEncontrados(List<Perfiles> perfilesEncontrados) {
        this.perfilesEncontrados = perfilesEncontrados;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
}
