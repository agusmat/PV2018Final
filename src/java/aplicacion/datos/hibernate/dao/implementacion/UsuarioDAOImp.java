/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;

import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.datos.hibernate.mapeos.Usuarios;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Agustin
 */
public class UsuarioDAOImp implements UsuarioDAO {

    @Override
    public List<Usuarios> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.like("usuEstado", true));
        return criteria.list();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarios consulta(String nombreUsuario, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.like("usuNombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("usuPassword", password));
        Usuarios u=null;
        if(!criteria.list().isEmpty()){
            u=(Usuarios)criteria.list().get(0);
        }
        return u;
    }

    @Override
    public void modificar(Usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Usuarios usuario) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
