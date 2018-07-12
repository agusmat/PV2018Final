/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DetallesPrestamoBean;
import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.PublicacionesBean;
import aplicacion.datos.hibernate.mapeos.DetallesPrestamos;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Prestamos;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class PrestamoLibroManagedBean {
    @ManagedProperty(value = "#{detallesPrestamoBean}")
    private DetallesPrestamoBean detallePrestamoBean;
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    @ManagedProperty(value = "#{publicacionesBean}")
    private PublicacionesBean publicacionesBean;
    private Publicaciones unaPublicacion;
    private Date fecha;
    private List<Publicaciones> listaPublicaciones;
    private List<Publicaciones> publicacionesFiltradas;
    private List<Perfiles> perfiles;
    private String preAdministrativo;
    private String dpTurno;
    /**
     * Creates a new instance of PrestamoLibroManagedBean
     */
    public PrestamoLibroManagedBean() {
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
        Prestamos unPrestamo=new Prestamos(1, usuarioPerfil, getFecha(), true, getPreAdministrativo());
        DetallesPrestamos unDetallePrestamo=new DetallesPrestamos(1, unPrestamo, getUnaPublicacion(), true, getFecha(), getDpTurno(), getFecha());
        getDetallePrestamoBean().agregarDetallesPrestamo(unDetallePrestamo);
    }

    /**
     * @return the detallePrestamoBean
     */
    public DetallesPrestamoBean getDetallePrestamoBean() {
        return detallePrestamoBean;
    }

    /**
     * @param detallePrestamoBean the detallePrestamoBean to set
     */
    public void setDetallePrestamoBean(DetallesPrestamoBean detallePrestamoBean) {
        this.detallePrestamoBean = detallePrestamoBean;
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

    /**
     * @return the preAdministrativo
     */
    public String getPreAdministrativo() {
        return preAdministrativo;
    }

    /**
     * @param preAdministrativo the preAdministrativo to set
     */
    public void setPreAdministrativo(String preAdministrativo) {
        this.preAdministrativo = preAdministrativo;
    }

    /**
     * @return the dpTurno
     */
    public String getDpTurno() {
        return dpTurno;
    }

    /**
     * @param dpTurno the dpTurno to set
     */
    public void setDpTurno(String dpTurno) {
        this.dpTurno = dpTurno;
    }
}
