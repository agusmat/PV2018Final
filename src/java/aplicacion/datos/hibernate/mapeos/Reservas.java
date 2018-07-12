package aplicacion.datos.hibernate.mapeos;
// Generated 21/06/2018 23:30:40 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Reservas generated by hbm2java
 */
public class Reservas  implements java.io.Serializable {


     private Integer revCodigo;
     private Perfiles perfiles;
     private Date revFechaEmision;
     private Date revFechaTurno;
     private boolean revEstado;
     private Set detallesReservases = new HashSet(0);

    public Reservas() {
    }

    public Reservas(Integer revCodigo, Perfiles perfiles, Date revFechaEmision, Date revFechaTurno, boolean revEstado) {
        this.revCodigo = revCodigo;
        this.perfiles = perfiles;
        this.revFechaEmision = revFechaEmision;
        this.revFechaTurno = revFechaTurno;
        this.revEstado = revEstado;
    }

	
    public Reservas(Perfiles perfiles, Date revFechaEmision, Date revFechaTurno, boolean revEstado) {
        this.perfiles = perfiles;
        this.revFechaEmision = revFechaEmision;
        this.revFechaTurno = revFechaTurno;
        this.revEstado = revEstado;
    }
    public Reservas(Perfiles perfiles, Date revFechaEmision, Date revFechaTurno, boolean revEstado, Set detallesReservases) {
       this.perfiles = perfiles;
       this.revFechaEmision = revFechaEmision;
       this.revFechaTurno = revFechaTurno;
       this.revEstado = revEstado;
       this.detallesReservases = detallesReservases;
    }
   
    public Integer getRevCodigo() {
        return this.revCodigo;
    }
    
    public void setRevCodigo(Integer revCodigo) {
        this.revCodigo = revCodigo;
    }
    public Perfiles getPerfiles() {
        return this.perfiles;
    }
    
    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }
    public Date getRevFechaEmision() {
        return this.revFechaEmision;
    }
    
    public void setRevFechaEmision(Date revFechaEmision) {
        this.revFechaEmision = revFechaEmision;
    }
    public Date getRevFechaTurno() {
        return this.revFechaTurno;
    }
    
    public void setRevFechaTurno(Date revFechaTurno) {
        this.revFechaTurno = revFechaTurno;
    }
    public boolean isRevEstado() {
        return this.revEstado;
    }
    
    public void setRevEstado(boolean revEstado) {
        this.revEstado = revEstado;
    }
    public Set getDetallesReservases() {
        return this.detallesReservases;
    }
    
    public void setDetallesReservases(Set detallesReservases) {
        this.detallesReservases = detallesReservases;
    }




}

