/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.datos.hibernate.dao.implementacion.UsuarioDAOImp;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Agustin
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
    public Usuarios validarUsuario(String nomUs, String passwUs){
    Usuarios usuario=null;
    UsuarioDAO usuarioDAO=new UsuarioDAOImp();
    usuario=usuarioDAO.consulta(nomUs, passwUs);
    return usuario;
    }
    public void agregarUsuario(Integer codigo, String username, String password, String tipo_usuario, boolean estado){
         UsuarioDAO usuarioDAO=new UsuarioDAOImp();
         Usuarios usuario=new Usuarios(codigo, username, password, tipo_usuario, estado);
         usuarioDAO.agregar(usuario);
    }
    public List<Usuarios> obtenerTodos(){
        UsuarioDAO usuarioDAO=new UsuarioDAOImp();
        return usuarioDAO.obtenerTodos();
    }
}
