package aplicacion.datos.hibernate.mapeos;
// Generated 21/06/2018 23:30:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer usuCodigo;
     private String usuNombreUsuario;
     private String usuPassword;
     private String usuTipoUsuario;
     private boolean usuEstado;
     private Set perfileses = new HashSet(0);

    public Usuarios() {
    }

    public Usuarios(Integer usuCodigo, String usuNombreUsuario, String usuPassword, String usuTipoUsuario, boolean usuEstado) {
        this.usuCodigo = usuCodigo;
        this.usuNombreUsuario = usuNombreUsuario;
        this.usuPassword = usuPassword;
        this.usuTipoUsuario = usuTipoUsuario;
        this.usuEstado = usuEstado;
    }
    
	
    public Usuarios(String usuNombreUsuario, String usuPassword, String usuTipoUsuario, boolean usuEstado) {
        this.usuNombreUsuario = usuNombreUsuario;
        this.usuPassword = usuPassword;
        this.usuTipoUsuario = usuTipoUsuario;
        this.usuEstado = usuEstado;
    }
    public Usuarios(String usuNombreUsuario, String usuPassword, String usuTipoUsuario, boolean usuEstado, Set perfileses) {
       this.usuNombreUsuario = usuNombreUsuario;
       this.usuPassword = usuPassword;
       this.usuTipoUsuario = usuTipoUsuario;
       this.usuEstado = usuEstado;
       this.perfileses = perfileses;
    }
   
    public Integer getUsuCodigo() {
        return this.usuCodigo;
    }
    
    public void setUsuCodigo(Integer usuCodigo) {
        this.usuCodigo = usuCodigo;
    }
    public String getUsuNombreUsuario() {
        return this.usuNombreUsuario;
    }
    
    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }
    public String getUsuPassword() {
        return this.usuPassword;
    }
    
    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }
    public String getUsuTipoUsuario() {
        return this.usuTipoUsuario;
    }
    
    public void setUsuTipoUsuario(String usuTipoUsuario) {
        this.usuTipoUsuario = usuTipoUsuario;
    }
    public boolean isUsuEstado() {
        return this.usuEstado;
    }
    
    public void setUsuEstado(boolean usuEstado) {
        this.usuEstado = usuEstado;
    }
    public Set getPerfileses() {
        return this.perfileses;
    }
    
    public void setPerfileses(Set perfileses) {
        this.perfileses = perfileses;
    }

    @Override
    public int hashCode() {
        return (usuCodigo != null)? (this.getClass().hashCode() + usuCodigo.hashCode()): super.hashCode();        
    }

    @Override
    public boolean equals(Object obj) {
            return (obj instanceof Usuarios) && (usuCodigo != null)? usuCodigo.equals(((Usuarios) obj).usuCodigo) :(obj == this);
             
    }

    @Override
    public String toString() {
        return String.format ("Usuarios: [%s, %s]", usuCodigo, usuNombreUsuario);
    }    
}

