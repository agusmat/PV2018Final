/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DetallesReservaBean;
import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.PublicacionesBean;
import aplicacion.datos.hibernate.mapeos.DetallesReservas;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import aplicacion.datos.hibernate.mapeos.Reservas;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.util.Date;
import java.util.List;
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
public class ReservaLibroManagedBean {

    @ManagedProperty(value = "#{detallesReservaBean}")
    private DetallesReservaBean detalleReservasBean;
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    @ManagedProperty(value = "#{publicacionesBean}")
    private PublicacionesBean publicacionesBean;
    private Publicaciones unaPublicacion;
    private Date fecha;
    private List<Publicaciones> listaPublicaciones;
    private List<Publicaciones> publicacionesFiltradas;
    private List<Perfiles> perfiles;

    /**
     * Creates a new instance of ReservaLibroManagedBean
     */
    public ReservaLibroManagedBean() {
        publicacionesBean = new PublicacionesBean();
        listarPublicacionesGuardadas();
    }

    public void listarPublicacionesGuardadas() {
        setListaPublicaciones(getPublicacionesBean().listarEditoriales());
    }

    public void establecerPublicacion(Publicaciones pub) {
        setUnaPublicacion(pub);
    }

    public void confirmarReserva() {
        Usuarios usuarios = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        setPerfiles(getPerfilBean().listarPerfiles());
        Perfiles usuarioPerfil = new Perfiles();
        for (Perfiles p : getPerfiles()) {
            if (p.getUsuarios().getUsuNombreUsuario().equals(usuarios.getUsuNombreUsuario())) {
                usuarioPerfil = p;
            }
        }
        Date fechaHoy = new Date();
        Reservas unaReserva=new Reservas(usuarioPerfil, fechaHoy, getFecha(), true);
        DetallesReservas unDetalleReserva=new DetallesReservas(getUnaPublicacion(), unaReserva, 1, true);
        getDetalleReservasBean().agregarDetallesReserva(unDetalleReserva);
    }

    /**
     * @return the detalleReservasBean
     */
    public DetallesReservaBean getDetalleReservasBean() {
        return detalleReservasBean;
    }

    /**
     * @param detalleReservasBean the detalleReservasBean to set
     */
    public void setDetalleReservasBean(DetallesReservaBean detalleReservasBean) {
        this.detalleReservasBean = detalleReservasBean;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
     * @return the publicacionesFiltradas
     */
    public List<Publicaciones> getPublicacionesFiltradas() {
        return publicacionesFiltradas;
    }

    /**
     * @param publicacionesFiltradas the publicacionesFiltradas to set
     */
    public void setPublicacionesFiltradas(List<Publicaciones> publicacionesFiltradas) {
        this.publicacionesFiltradas = publicacionesFiltradas;
    }

    /**
     * @return the perfiles
     */
    public List<Perfiles> getPerfiles() {
        return perfiles;
    }

    /**
     * @param perfiles the perfiles to set
     */
    public void setPerfiles(List<Perfiles> perfiles) {
        this.perfiles = perfiles;
    }

}
