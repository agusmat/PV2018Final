/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.ReservasBean;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Reservas;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class ReservasManagedBean {
    private Integer revCodigo;
    private Perfiles perfiles;
    private Date revFechaEmision;
    private Date revFechaTurno;
    private boolean revEstado;
    private boolean perEstado;
     private Integer perCodigo;
     private Usuarios usuarios;
     private String perApellidos;
     private String perNombres;
     private String perDni;
     private Date perFechaNac;
     private String perEmail;
     private String perDireccion;
     private String perTelefono;
     private Integer usuCodigo;
     private String usuNombreUsuario;
     private String usuPassword;
     private String usuTipoUsuario;
     private boolean usuEstado;
     private ReservasBean reservasBean;
     private List<Reservas> listadoRes;
     private Reservas unaReserva;
    /**
     * Creates a new instance of ReservasManagedBean
     */
    public ReservasManagedBean() {
    }
    private void listarPerfiles(){
        setListadoRes(getReservasBean().listarEditoriales());
    }
    public void establecerPerfil(Reservas per){
        setUnaReserva(per);
    }
    public void agregarPerfil(){
        setUsuarios(new Usuarios(1, getUsuNombreUsuario(), getUsuPassword(), getUsuTipoUsuario(), true));
        setPerfiles(new Perfiles(true, getUsuarios(), getPerApellidos(), getPerNombres(), "111111", new Date(), "email", "direccion", "telefono"));
        setUnaReserva(new Reservas(1, getPerfiles(), new Date(), new Date(), true));
        
        try{
            getReservasBean().agregarReservas(getUnaReserva());
        }
        catch(Exception e){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"ERROR","La reserva no se ha podido crear");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"INFO","La reserva se ha podido crear");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        listarPerfiles();
    }
    public void eliminarPerfil(){
        getUnaReserva().getPerfiles().getUsuarios().setUsuEstado(false);
        getUnaReserva().getPerfiles().setPerEstado(false);
        getUnaReserva().setRevEstado(false);
        getReservasBean().modificarPerfil(getUnaReserva());
        listarPerfiles();
        
    }

    /**
     * @return the revCodigo
     */
    public Integer getRevCodigo() {
        return revCodigo;
    }

    /**
     * @param revCodigo the revCodigo to set
     */
    public void setRevCodigo(Integer revCodigo) {
        this.revCodigo = revCodigo;
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
     * @return the revFechaEmision
     */
    public Date getRevFechaEmision() {
        return revFechaEmision;
    }

    /**
     * @param revFechaEmision the revFechaEmision to set
     */
    public void setRevFechaEmision(Date revFechaEmision) {
        this.revFechaEmision = revFechaEmision;
    }

    /**
     * @return the revFechaTurno
     */
    public Date getRevFechaTurno() {
        return revFechaTurno;
    }

    /**
     * @param revFechaTurno the revFechaTurno to set
     */
    public void setRevFechaTurno(Date revFechaTurno) {
        this.revFechaTurno = revFechaTurno;
    }

    /**
     * @return the revEstado
     */
    public boolean isRevEstado() {
        return revEstado;
    }

    /**
     * @param revEstado the revEstado to set
     */
    public void setRevEstado(boolean revEstado) {
        this.revEstado = revEstado;
    }

    /**
     * @return the perEstado
     */
    public boolean isPerEstado() {
        return perEstado;
    }

    /**
     * @param perEstado the perEstado to set
     */
    public void setPerEstado(boolean perEstado) {
        this.perEstado = perEstado;
    }

    /**
     * @return the perCodigo
     */
    public Integer getPerCodigo() {
        return perCodigo;
    }

    /**
     * @param perCodigo the perCodigo to set
     */
    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    /**
     * @return the usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the perApellidos
     */
    public String getPerApellidos() {
        return perApellidos;
    }

    /**
     * @param perApellidos the perApellidos to set
     */
    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    /**
     * @return the perNombres
     */
    public String getPerNombres() {
        return perNombres;
    }

    /**
     * @param perNombres the perNombres to set
     */
    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    /**
     * @return the perDni
     */
    public String getPerDni() {
        return perDni;
    }

    /**
     * @param perDni the perDni to set
     */
    public void setPerDni(String perDni) {
        this.perDni = perDni;
    }

    /**
     * @return the perFechaNac
     */
    public Date getPerFechaNac() {
        return perFechaNac;
    }

    /**
     * @param perFechaNac the perFechaNac to set
     */
    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }

    /**
     * @return the perEmail
     */
    public String getPerEmail() {
        return perEmail;
    }

    /**
     * @param perEmail the perEmail to set
     */
    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    /**
     * @return the perDireccion
     */
    public String getPerDireccion() {
        return perDireccion;
    }

    /**
     * @param perDireccion the perDireccion to set
     */
    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    /**
     * @return the perTelefono
     */
    public String getPerTelefono() {
        return perTelefono;
    }

    /**
     * @param perTelefono the perTelefono to set
     */
    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    /**
     * @return the usuCodigo
     */
    public Integer getUsuCodigo() {
        return usuCodigo;
    }

    /**
     * @param usuCodigo the usuCodigo to set
     */
    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    /**
     * @return the usuNombreUsuario
     */
    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    /**
     * @param usuNombreUsuario the usuNombreUsuario to set
     */
    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    /**
     * @return the usuPassword
     */
    public String getUsuPassword() {
        return usuPassword;
    }

    /**
     * @param usuPassword the usuPassword to set
     */
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    /**
     * @return the usuTipoUsuario
     */
    public String getUsuTipoUsuario() {
        return usuTipoUsuario;
    }

    /**
     * @param usuTipoUsuario the usuTipoUsuario to set
     */
    public void setUsuTipoUsuario(String usuTipoUsuario) {
        this.usuTipoUsuario = usuTipoUsuario;
    }

    /**
     * @return the usuEstado
     */
    public boolean isUsuEstado() {
        return usuEstado;
    }

    /**
     * @param usuEstado the usuEstado to set
     */
    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    /**
     * @return the reservasBean
     */
    public ReservasBean getReservasBean() {
        return reservasBean;
    }

    /**
     * @param reservasBean the reservasBean to set
     */
    public void setReservasBean(ReservasBean reservasBean) {
        this.reservasBean = reservasBean;
    }

    /**
     * @return the listadoRes
     */
    public List<Reservas> getListadoRes() {
        return listadoRes;
    }

    /**
     * @param listadoRes the listadoRes to set
     */
    public void setListadoRes(List<Reservas> listadoRes) {
        this.listadoRes = listadoRes;
    }

    /**
     * @return the unaReserva
     */
    public Reservas getUnaReserva() {
        return unaReserva;
    }

    /**
     * @param unaReserva the unaReserva to set
     */
    public void setUnaReserva(Reservas unaReserva) {
        this.unaReserva = unaReserva;
    }
}
