/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import aplicacion.datos.lista.ListaTipoUsuario;
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
public class UsuarioManagedBean implements Serializable{

    /**
     * Creates a new instance of UsuarioManagedBean
     */
    
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String username;
    private String contraseña;
    private Integer codigo;
    private String tipo_usuario;
    private boolean estado;
    private List<Usuarios> listaUsuario;
    private ListaTipoUsuario listaTipoUsuario;
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
        usuarioBean= new UsuarioBean();
        listaTipoUsuario=new ListaTipoUsuario();
        listaTipoUsuario.getListaTipos().add("Supervisor");
        listaTipoUsuario.getListaTipos().add("Administrador");
        listaTipoUsuario.getListaTipos().add("Final");
        listarUsuarios();
    }
    public String validarUsuario(){
        String resultado=null;
        Usuarios usuario=null;
        usuario=usuarioBean.validarUsuario(getUsername(), getContraseña());
        if(usuario==null){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidas","Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else{
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Credenciales Correctas","Credenciales Correctas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            resultado="/bienvienida";
        }
        return resultado;
    }
    public void listarUsuarios(){
        listaUsuario=usuarioBean.obtenerTodos();
    }
    public String getUsuarioValidado(){
        Usuarios usuario=(Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getUsuNombreUsuario();
    }
    public String cerrarSesion(){
        String resultado="/login";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Sesion Cerrada","Sesion Cerrada con exito");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return resultado;
    }
    public int verificarSesion(){
       
        int tipo =0;
        Usuarios usuario=(Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if(usuario!=null){
        if(usuario.getUsuTipoUsuario().equals("final")){
            tipo=1;
        }
        if(usuario.getUsuTipoUsuario().equals("administrador")){
            tipo=2;
        }
        if(usuario.getUsuTipoUsuario().equals("supervisor")){
            tipo=3;
        }
        }
        
        return tipo;
    }
    public boolean verificarSesionMenu() {
        boolean sesionValida = false;
        Usuarios usuario = (Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuario != null) {
            sesionValida = true;
        }
        return sesionValida;
    }
    public void agregarUsuario(){
        estado=true;
        usuarioBean.agregarUsuario(getCodigo(), username, contraseña, getTipo_usuario(), isEstado());
        setListaUsuario((List<Usuarios>) usuarioBean.obtenerTodos());
    }
    public String crearUsuarioFinal(){
        estado=true;
        usuarioBean.agregarUsuario(1, username, contraseña, "final", isEstado());
        setListaUsuario((List<Usuarios>) usuarioBean.obtenerTodos());
        return "/login";
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the listaUsuario
     */
    public List<Usuarios> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * @param listaUsuario the listaUsuario to set
     */
    public void setListaUsuario(List<Usuarios> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    /**
     * @return the listaTipoUsuario
     */
    public ListaTipoUsuario getListaTipoUsuario() {
        return listaTipoUsuario;
    }

    /**
     * @param listaTipoUsuario the listaTipoUsuario to set
     */
    public void setListaTipoUsuario(ListaTipoUsuario listaTipoUsuario) {
        this.listaTipoUsuario = listaTipoUsuario;
    }
}
